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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kh.spring.DTO.FilesDTO;
import kh.spring.repositories.FilesDAO;

@Controller
@RequestMapping("/file/")
public class FileController {

	@Autowired
	private HttpSession session;

	@Autowired
	private FilesDAO dao;
	
	@RequestMapping("upload")
	public String upload(String message, MultipartFile[] files) throws Exception {

		String realPath = session.getServletContext().getRealPath("upload");
		File realPathFile = new File(realPath);
		if(!realPathFile.exists()) {realPathFile.mkdir();}
		// 리얼패스에 upload 폴더를 설정하고 없으면 만들어 파일을 저장.

		if(files!=null) {// jsp에서 name값으로 files가 없는 경우를 걸러줌
			for(MultipartFile file : files) {
				
				if(file.isEmpty()) {break;} // 파일을 선택 안했을 때에 걸러냄
				//파일이 비어있다면> break
				String oriName = file.getOriginalFilename(); //oriname은 있으나 sysname기능 없음
				String sysName = UUID.randomUUID() + "_" + oriName;
				//randomUUID 가 랜덤값을 만듬 + sysname을 붙여줌 

				file.transferTo(new File(realPath+"/"+sysName));
				dao.insert(new FilesDTO(0,oriName,sysName,0));
			}
		}

		return "redirect:/";
	}
	
	@ResponseBody
	@RequestMapping("list")
	public List<FilesDTO> list() {
		List<FilesDTO> list = dao.selectAll();
		
		return list;
	}

	
	@RequestMapping("download")
	public void download(String oriName, String sysName, HttpServletResponse response) throws Exception {
		//oriName = 클라이언트가 다운받는 파일의 이름을 지정하기 위해서 받음
		//sysName = 서버쪽에 저장된 target의 이름
		//response = dispatcher를 거치지 않고 stream을 통해 직접 전송하기 위해 사용
		String realPath = session.getServletContext().getRealPath("upload");
		File target = new File(realPath +"/"+sysName);
		// 다운받을 파일을 선택하여 File 객체로 생성
		oriName = new String(oriName.getBytes("utf8"),"ISO-8859-1");
		response.reset();
		response.setHeader("content-disposition", "attachment;filename"+oriName);
		// response 헤더에 보내려는 데이터가 첨부파일임을 밝히고 적절히 인코딩 된 파일 이름을 지정
		
		try(DataInputStream dis = new DataInputStream(new FileInputStream(target));
			DataOutputStream dos = new DataOutputStream(response.getOutputStream());){
		byte[] fileContents = dis.readAllBytes();
		// cpu는 램에있는것만 가져옴. > 하드에서 램으로 파일을 가져와서 보관
		dos.write(fileContents);
		dos.flush();
		// dos가 읽어들인 fileCOntents를 보냄
		}
		// response에 넣을 내용을 넣는 과정으로 dis에 지정한 타겟을 설정하고 dos로 가서 response의 stream에 넣음
		// 타겟 파일의 내용을 모두 추출해 response stream으로 직접 출력
		
	}

}
