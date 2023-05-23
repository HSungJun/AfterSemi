package kh.spring.repositories;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import kh.spring.dto.MembersDTO;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSessionTemplate mbs;
	
	public int join(MembersDTO dto) {
		return mbs.insert("Member.join",dto);
	}

	public MembersDTO IdCheck(String id) {
		return mbs.selectOne("Member.memberInfo", id);
	}
	
	public MembersDTO login(String id,String pw) {
		Map<String, String> param = new HashMap<>();
		param.put("id", id);
		param.put("pw", pw);
		return mbs.selectOne("Member.login", param);
	}

	public int memberOut(String id) {
		return mbs.delete("Member.delete",id);
		}

	public MembersDTO memberInfo(String id) {
		return mbs.selectOne("Member.memberInfo",id);
	}

	public int updateMyInfo(MembersDTO dto) {
		return mbs.update("Member.updateMyInfo",dto);
	}
	
	
}
