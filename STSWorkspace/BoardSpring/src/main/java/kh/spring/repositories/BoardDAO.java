package kh.spring.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kh.spring.dto.BoardDTO;
import kh.spring.dto.MembersDTO;

@Repository
public class BoardDAO {
	
	@Autowired
	private JdbcTemplate jdbc;

	public List<BoardDTO> boardList() {
		String sql = "select * from board";
		return jdbc.query(sql, new BeanPropertyRowMapper<BoardDTO>(BoardDTO.class));
		
		
	}
	
	
	
	
}
