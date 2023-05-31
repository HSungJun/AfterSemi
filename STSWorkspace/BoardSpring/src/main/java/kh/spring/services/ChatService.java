package kh.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dto.ChatDTO;
import kh.spring.repositories.ChatDAO;

@Service
public class ChatService {

	@Autowired
	private ChatDAO dao;
	
	public List<ChatDTO> chatList() {
		return ChatDAO.chatList();
	}
	
	public int send(String id, String message, Object object) {
		return ChatDAO.send(id,message);
	}
	
}
