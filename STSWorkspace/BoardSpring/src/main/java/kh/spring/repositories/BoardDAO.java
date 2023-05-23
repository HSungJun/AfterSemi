package kh.spring.repositories;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kh.spring.dto.BoardDTO;
import kh.spring.dto.MembersDTO;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSessionTemplate mbs;

	public List<BoardDTO> boardList() {
		return mbs.selectList("Board.boardList");
		
	}

	public int write(BoardDTO dto) {
		return mbs.update("Board.write",dto);

	}

	public BoardDTO toContent(BoardDTO dto) {
		return mbs.selectOne("Board.toContents",dto);
	}
	
	
	
	
}
