package kh.spring.services;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kh.spring.dto.FilesDTO;
import kh.spring.repositories.FilesDAO;

@Service
public class FileService {

	@Autowired
	private FilesDAO filesDAO;
	
	public void write(String realPath, MultipartFile[] files,int parent_seq) throws Exception {
		
		File realPathFile = new File(realPath);
		if(!realPathFile.exists()) {realPathFile.mkdir();}

		if(files!=null) {
			for(MultipartFile file : files) {
				if(file.isEmpty()) {break;} 
				String oriName = file.getOriginalFilename(); //oriname은 있으나 sysname기능 없음
				String sysName = UUID.randomUUID() + "_" + oriName;
				file.transferTo(new File(realPath+"/"+sysName));
				filesDAO.write(new FilesDTO(0,oriName,sysName,parent_seq));
			}
		}
	}

	public List<FilesDTO> getfile(int seq) {
		return null;
	}

	
	
}