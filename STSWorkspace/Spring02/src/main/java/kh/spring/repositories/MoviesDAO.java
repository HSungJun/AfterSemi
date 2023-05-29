package kh.spring.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.MoviesDTO;

@Repository
public class MoviesDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public int insert(MoviesDTO dto) {
		return mybatis.insert("Movies.insert",dto);
	}
	
	public int inserthistory(MoviesDTO dto) {
		return mybatis.insert("Movies.insertHistory",dto);
	}
	
	public List<MoviesDTO> selectAll(){
		return mybatis.selectList("Movies.selectAll");
	}
	
	public int deleteMovieById (int id) {
		return mybatis.delete("Movies.delete",id);
	}
	
	public int modifyMovieById(MoviesDTO dto)  {
		return mybatis.update("Movies.update",dto);
	}

	public List<MoviesDTO> selectByCon(String column, String value) {
		Map<String, String> param = new HashMap<>();
		param.put("column", column);
		param.put("value", value);
		
		return mybatis.selectList("Movies.selectByCon",param);
	}

	public List<MoviesDTO> selectByMultiCon(MoviesDTO dto) {

		return mybatis.selectList("Movies.selectByMultiCon",dto);
	}

	
	
	
	
	
	
	
	
	
	
	
	

//	@Autowired
//	private JdbcTemplate jdbc;
//	
//	public int insert(MoviesDTO dto) {
//		String sql = "insert into movies values(movies_seq.nextval,?,?)";
//		return jdbc.update(sql,dto.getTitle(),dto.getGenre());
//		
//	}
//	//Spring JDBC > select > 단일값 = quertForObjecct / 대량값 query
//	//insert update delete > jdbc.update
//	
//	public int deleteMovieById (int delid) {
//		String sql = "delete from movies where id = ?";
//		return jdbc.update(sql,delid);
//	}
//	
//	public int modifyMovieById(MoviesDTO dto)  {
//		String sql = "update movies set title = ?, genre = ? where id = ?";
//		return jdbc.update(sql, dto.getTitle(), dto.getGenre(),dto.getId());
//	}
	
	//-------------------------------------------------------------------------
	
	
/*	public List<MoviesDTO> selectAll(){
		String sql = "select * from movies";
		return jdbc.query(sql, new RowMapper<MoviesDTO>() {
			//경고창 > 콜백을 구현하면 매칭 후 리턴해줌
			//여러번 돌아서 리스트로 모아서 보내주나 object인 이유는 어떤 형태인지 모르기떄문에 다형성이용
//			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//				return null;
//			} > RowMapper 뒤에 데이터형태 입력시 아래처럼 나옴
			@Override
			public MoviesDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String genre = rs.getString("genre");
			
				return new MoviesDTO(id,title,genre);
			} // 한줄 돌때마다 DTO로 만들어서 query 메서드가 List로 만들어서 리턴함.
		});
		// sql 이후 무슨 기능을 할지 작성해야함. 
				//메서드를 변수로 넣을 수 없기 떄문에 메세지를 구현해야하도록 인스턴스를 만들어서 넘겨야함
				// RowMapper 인터페이스 - 다형성과 콜백을 위한 것
		//추상메서드 new? 내용을 넣으면 가능
	}
	*/
	
	// list 불러오는것도 상단처럼 되나 DTO와 DB의 컬럼명이 같다는 전제하에 아래와 같이 사용 가능
//	public List<MoviesDTO> selectAll(){
//		String sql = "select * from movies";
//		return jdbc.query(sql, new BeanPropertyRowMapper<MoviesDTO>(MoviesDTO.class));
//	
//	}
//	
//	
//	//.class 는 자료형을 표현하는 말
//	public MoviesDTO selectById(int id) {
//		String sql = "select * from movies where id = ?";
//		return jdbc.queryForObject(sql, new BeanPropertyRowMapper<MoviesDTO>(MoviesDTO.class),id);
//	}
//	
//	public int selectCount() {
//		String sql = "select count(*) from movies";
//		return jdbc.queryForObject(sql, Integer.class);
//	}
	
	
	
	
	
	
//	@Autowired
//	private DataSource ds;
//	
//	public int insert(MoviesDTO dto) throws Exception{
//		String sql = "insert into movies values(movies_seq.nextval,?,?)";
//		try(Connection con = ds.getConnection();
//				PreparedStatement pstat = con.prepareStatement(sql);
//				){
//			pstat.setString(1, dto.getTitle());
//			pstat.setString(2, dto.getGenre());
//			return pstat.executeUpdate();
//		}
//	}
//
//	public List<MoviesDTO> selectAll() throws Exception{
//		String sql = "select * from movies";
//		try(Connection con = ds.getConnection();
//				PreparedStatement pstat = con.prepareStatement(sql);
//				ResultSet rs = pstat.executeQuery()){
//				List<MoviesDTO> list = new ArrayList<>();
//				while(rs.next()) {
//					list.add(new MoviesDTO(rs.getInt("id"),rs.getString("title"),rs.getString("genre")));
//				}
//				return list;
//		}
//	}
//
//	public int deleteMovieById(int id) throws Exception {
//		String sql = "delete from movies where id = ?";
//		try(Connection con = ds.getConnection();
//				PreparedStatement pstat = con.prepareStatement(sql);){
//			pstat.setInt(1, id);
//			int result = pstat.executeUpdate();
//			return result;
//		}
//	}
//
//	public int modifyMovieById(MoviesDTO dto) throws Exception {
//		String sql = "update movies set title = ?, genre = ? where id = ?";
//		try(Connection con = ds.getConnection();
//				PreparedStatement pstat = con.prepareStatement(sql);){
//			pstat.setString(1, dto.getTitle());
//			pstat.setString(2, dto.getGenre());
//			pstat.setInt(3, dto.getId());
//		int result = pstat.executeUpdate();
//		return result;
//	}
//	}
//	
	
}
