package kh.spring.controllers;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import kh.spring.dto.BoardDTO;
import kh.spring.dto.FilesDTO;
import kh.spring.repositories.BoardDAO;
import kh.spring.repositories.FilesDAO;

@Controller
@RequestMapping("/board/")
public class BoardController {
	
	@Autowired
	private BoardDAO bdao;
	
	@Autowired
	private FilesDAO fdao;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("toWrite")
	public String toWrite() {
		return "board/write";
	}
	
	@RequestMapping("boardlist")
	public String boardlist(Model model) {
		
		List<BoardDTO> list = bdao.boardList();
		model.addAttribute("list", list);
		
		return "/board/boardlist";
	}
	
	@RequestMapping("write")
	public String write(BoardDTO bdto, MultipartFile[] files) throws Exception {
		int result = bdao.write(bdto);
		
		int parent_seq = bdao.selectseq();
		
		String realPath = session.getServletContext().getRealPath("upload");
		File realPathFile = new File(realPath);
		if(!realPathFile.exists()) {realPathFile.mkdir();}

		if(files!=null) {
			for(MultipartFile file : files) {
				if(file.isEmpty()) {break;} 
				String oriName = file.getOriginalFilename(); //oriname은 있으나 sysname기능 없음
				String sysName = UUID.randomUUID() + "_" + oriName;
				file.transferTo(new File(realPath+"/"+sysName));
				fdao.write(new FilesDTO(0,oriName,sysName,parent_seq));
			}
		}
		return "redirect:/board/boardlist";
	}
	
	@RequestMapping("contentView")
	public String contentView(int seq,Model model, HttpServletResponse response) throws Exception {

		BoardDTO Bdto = bdao.toContent(seq);
		
		String oriName = fdao.getOriName(seq);
		String sysName = fdao.getSysName(seq);
		
		String realPath = session.getServletContext().getRealPath("upload");
		File target = new File(realPath +"/"+sysName);
		oriName = new String(oriName.getBytes("utf8"),"ISO-8859-1");
		response.reset();
		response.setHeader("content-disposition", "attachment;filename"+oriName);
		
		try(DataInputStream dis = new DataInputStream(new FileInputStream(target));
			DataOutputStream dos = new DataOutputStream(response.getOutputStream());){
		byte[] fileContents = dis.readAllBytes();
		dos.write(fileContents);
		dos.flush();
		}
		
		
		model.addAttribute("dto", Bdto);
		
		
		return "board/content";
	}
	
	@RequestMapping("modify")
	public String modify(BoardDTO dto) {
		return "board/content?";
	}
	
	
	
	
}
