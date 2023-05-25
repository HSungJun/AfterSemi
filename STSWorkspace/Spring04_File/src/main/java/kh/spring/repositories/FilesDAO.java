package kh.spring.repositories;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.DTO.FilesDTO;

@Repository
public class FilesDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;

	public int insert(FilesDTO filesDTO) {
		return mybatis.insert("Files.insert",filesDTO);
	}
	
	public List<FilesDTO> selectAll(){
		return mybatis.selectList("Files.selectAll");
	}
	
	
}
