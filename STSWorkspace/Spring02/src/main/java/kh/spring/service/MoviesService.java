package kh.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kh.spring.dto.MoviesDTO;
import kh.spring.repositories.MoviesDAO;

@Service
public class MoviesService {
	
	@Autowired
	private MoviesDAO dao;
	
	@Transactional
	public void transactionTest(MoviesDTO dto) {
		dao.insert(dto);
		dao.inserthistory(dto);
		
	}
	
	
}
