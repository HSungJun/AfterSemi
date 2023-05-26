package kh.spring.controllers;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
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
import kh.spring.services.BoardService;
import kh.spring.services.FileService;

@Controller
@RequestMapping("/board/")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private FileService fileService;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("toWrite")
	public String toWrite() {
		return "board/write";
	}
	
	@RequestMapping("boardlist")
	public String boardlist(Model model) throws Exception{
		List<BoardDTO> list = boardService.boardList();
		model.addAttribute("list", list);
		return "/board/boardlist";
	}
	
	@RequestMapping("write")
	public String write(BoardDTO bdto, MultipartFile[] files) throws Exception {
		int parent_seq = boardService.write(bdto);
		String realPath = session.getServletContext().getRealPath("upload");
		fileService.write(realPath, files,parent_seq);
			return "redirect:/board/boardlist";
	}
	
	@RequestMapping("contentView")
	public String contentView(BoardDTO dto,Model model, HttpServletResponse response) throws Exception {
		BoardDTO Bdto = boardService.toContent(dto.getSeq());
		model.addAttribute("files",fileService.getfile(dto.getSeq()));
		model.addAttribute("dto", Bdto);
		return "board/content";
	}
	
	@RequestMapping("modify")
	public String modify(BoardDTO dto) {
		return "board/content?";
	}
	
	@RequestMapping("download")
	public void download(String oriName, String sysName, HttpServletResponse response) throws Exception {
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
	}
	
	
}
