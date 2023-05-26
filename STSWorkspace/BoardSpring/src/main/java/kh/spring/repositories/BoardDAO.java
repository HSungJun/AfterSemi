package kh.spring.repositories;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.BoardDTO;
import kh.spring.dto.FilesDTO;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSessionTemplate mbs;
	
	public int mkBoardSeq() {
		return mbs.selectOne("Board.mkBoardSeq");
	}

	public List<BoardDTO> boardList() {
		return mbs.selectList("Board.boardList");
	}

	public int write(BoardDTO dto) {
		mbs.update("Board.write",dto);
		return dto.getSeq();
	}

	public BoardDTO toContent(int seq) {
		return mbs.selectOne("Board.toContents",seq);
	}

	public int selectseq() {
		return mbs.selectOne("Board.selectseq");
	}
	
	
	
	
}
