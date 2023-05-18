package kh.spring.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.MessagesDTO;

@Repository
public class MessagesDAO {
	
	@Autowired
	private DataSource ds;

	public int writeMsg(MessagesDTO dto) throws Exception{
		String sql = "insert into messages values(messages_seq.nextval,?,?)";
		try(Connection con = ds.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				){
			pstat.setString(1, dto.getWriter());
			pstat.setString(2, dto.getMessage());
			return pstat.executeUpdate();
		}
	}

	public List<MessagesDTO> selectAll() throws Exception{
		String sql = "select * from messages";
		try(Connection con = ds.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				ResultSet rs = pstat.executeQuery()){
				List<MessagesDTO> list = new ArrayList<>();
				while(rs.next()) {
					list.add(new MessagesDTO(rs.getInt("seq"),rs.getString("writer"),rs.getString("message")));
				}
				return list;
		}
	}

	public int deleteMovieById(int delseq) throws Exception {
		String sql = "delete from messages where seq = ?";
		try(Connection con = ds.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setInt(1, delseq);
			int result = pstat.executeUpdate();
			return result;
		}
	}

	public int modifyMsgBySeq(MessagesDTO dto) throws Exception {
		String sql = "update messages set writer = ?, message = ? where seq = ?";
		try(Connection con = ds.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setString(1, dto.getWriter());
			pstat.setString(2, dto.getMessage());
			pstat.setInt(3, dto.getSeq());
		int result = pstat.executeUpdate();
		return result;
	}
	}
		
	
	
	
	
}
