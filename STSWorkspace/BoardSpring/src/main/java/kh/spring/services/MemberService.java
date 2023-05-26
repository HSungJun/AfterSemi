package kh.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import commons.EncryptionUnits;
import kh.spring.dto.MembersDTO;
import kh.spring.repositories.MemberDAO;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;
	
	public String shapw(String pw) throws Exception {
		return EncryptionUnits.sha512(pw);
		
	}
	
	public int join(MembersDTO dto) {
		return memberDAO.join(dto);
	}
	
	public MembersDTO IdCheck(String id) {
		return memberDAO.IdCheck(id);
	}
	
	public MembersDTO login(String id, String pw) {
		return memberDAO.login(id, pw);
	}
	
	public int memberOut(String id) {
		return memberDAO.memberOut(id);
	}
	
	public MembersDTO memberInfo(String id) {
		return memberDAO.memberInfo(id);
	}
	
	public int updateMyInfo(MembersDTO dto) {
		return memberDAO.updateMyInfo(dto);
	}
	
	
}
