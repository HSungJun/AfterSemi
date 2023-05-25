package kh.spring.repositories;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.DTO.MessageDTO;

@Repository
public class MessageDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;

	public int insertMessage(String name, String message) {
		return mybatis.insert("Message.insertMessage",message);
	}

	public List<MessageDTO> listMessage() {
		return mybatis.selectList("Message.listMessage");
	}

	
	
	
}
