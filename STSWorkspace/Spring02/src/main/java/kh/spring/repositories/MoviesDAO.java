package kh.spring.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.MoviesDTO;

@Repository
public class MoviesDAO {

	@Autowired
	private DataSource ds;
	
	public int insert(MoviesDTO dto) throws Exception{
		String sql = "insert into movies values(movies_seq.nextval,?,?)";
		try(Connection con = ds.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				){
			pstat.setString(1, dto.getTitle());
			pstat.setString(2, dto.getGenre());
			return pstat.executeUpdate();
		}
	}

	public List<MoviesDTO> selectAll() throws Exception{
		String sql = "select * from movies";
		try(Connection con = ds.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				ResultSet rs = pstat.executeQuery()){
				List<MoviesDTO> list = new ArrayList<>();
				while(rs.next()) {
					list.add(new MoviesDTO(rs.getInt("id"),rs.getString("title"),rs.getString("genre")));
				}
				return list;
		}
	}

	public int deleteMovieById(int id) throws Exception {
		String sql = "delete from movies where id = ?";
		try(Connection con = ds.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setInt(1, id);
			int result = pstat.executeUpdate();
			return result;
		}
	}

	public int modifyMovieById(MoviesDTO dto) throws Exception {
		String sql = "update movies set title = ?, genre = ? where id = ?";
		try(Connection con = ds.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setString(1, dto.getTitle());
			pstat.setString(2, dto.getGenre());
			pstat.setInt(3, dto.getId());
		int result = pstat.executeUpdate();
		return result;
	}
	}
	
	
}
