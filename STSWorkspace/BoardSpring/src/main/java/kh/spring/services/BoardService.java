package kh.spring.services;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kh.spring.dto.BoardDTO;
import kh.spring.dto.FilesDTO;
import kh.spring.repositories.BoardDAO;

@Service
public class BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	public List<BoardDTO> boardList() {
		return boardDAO.boardList();
	}
	
	public int write(BoardDTO dto) {
		return boardDAO.write(dto);
	}
	
	public BoardDTO toContent(int seq) {
		return boardDAO.toContent(seq);
	}
	
}
