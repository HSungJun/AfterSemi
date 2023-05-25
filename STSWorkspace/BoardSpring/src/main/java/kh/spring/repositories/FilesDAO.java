package kh.spring.repositories;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.spring.dto.FilesDTO;

@Repository
public class FilesDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;

	public int write(FilesDTO fdto) {
		return mybatis.insert("Files.insert",fdto);
	}
	
	public String getOriName(int seq) {
		return mybatis.selectOne("Files.getOriName",seq);
	}
	
	public String getSysName(int seq) {
		return mybatis.selectOne("Files.getSysName",seq);
	}

}
