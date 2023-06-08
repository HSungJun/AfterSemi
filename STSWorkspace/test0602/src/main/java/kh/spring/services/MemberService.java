package kh.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.spring.dto.MemberDTO;
import kh.spring.repositories.MemberDAO;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO dao;
	
	@RequestMapping("insertMember")
	@Transactional
	public int insertMember(MemberDTO dto) {
		return dao.insertMember(dto);
	}
	
}
