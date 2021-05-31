package lsj.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import lsj.spring.vo.Grade;

@Repository("gdao")
public class GradeDAOImpl implements GradeDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void insertGrade(Grade gd) {
		String sql = "insert into sungjuk (name,kor,eng,mat,tot,mean,grd)"
				+ " values (?,?,?,?,?,?,?)";
		Object[] params = new Object[] {
				gd.getName(), gd.getKor(), gd.getEng(), gd.getMat(),
				gd.getTot(), gd.getAvg(), gd.getGrd() +"" };
		
		int cnt = jdbcTemplate.update(sql, params);
		
		if(cnt > 0) System.out.println("성적 추가됨");
	}

	@Override
	public List<Grade> selectAllGrade() {
		String sql = " select name, kor, eng, mat from sungjuk "
				+ " order by sjno desc";
		RowMapper<Grade> mapper = new GradeMapper();
		// Callback 클래스만 등록하고 호출/실행은 따로하지 않음
		// 단, query method가 실행하는 도중
		// (결과집합이 존재하면) rs.next가 참인 경우 
		// IoC컨테이너가 mapper 객체의 mapRow를 호출함
		
		
		return jdbcTemplate.query(sql, mapper);
	}
	
	protected class GradeMapper implements RowMapper<Grade> {

		@Override
		public Grade mapRow(ResultSet rs, int num) throws SQLException {
			
			String name = rs.getString("name");
			int kor = rs.getInt("kor");
			int eng = rs.getInt("eng");
			int mat = rs.getInt("mat");
			Grade gd = new Grade(name,kor,eng,mat);
			return gd;
		}
		
	}

	@Override
	public Grade selectOneGrade(int gno) {
		String sql = "select * from sungjuk where sjno = ? ";
		
		Object[] params = new Object[] { gno };
		
		RowMapper<Grade> mapper = new GradeOneMapper();
		// Callback 클래스만 등록하고 호출/실행은 따로하지 않음
		// 단, query method가 실행하는 도중
		// (결과집합이 존재하면) rs.next가 참인 경우 
		// IoC컨테이너가 mapper 객체의 mapRow를 호출함
		
		return jdbcTemplate.queryForObject(sql, params, mapper);
	}
	
	protected class GradeOneMapper implements RowMapper<Grade> {
		
		
		@Override
		public Grade mapRow(ResultSet rs, int num) throws SQLException {
			String name = rs.getString("name");
			int kor = rs.getInt("kor");
			int eng = rs.getInt("eng");
			int mat = rs.getInt("mat");
			Grade gd = new Grade(name,kor,eng,mat);
			gd.setTot(rs.getInt("tot"));
			gd.setAvg(rs.getInt("mean"));
			gd.setGrd(rs.getString("grd").charAt(0));
			
			return gd;
		}
		
	}

	@Override
	public void updateGrade(Grade gd) {
		String sql="update sungjuk set "
				+ "kor = ? ,eng = ? ,mat = ?, "
				+ "tot = ? ,mean = ? ,grd= ? where sjno = ? ";
		Object[] params = new Object[] {
				gd.getKor(), gd.getEng(), gd.getMat(),
				gd.getTot(), gd.getAvg(), gd.getGrd() + "",
				gd.getSjno()};
		int cnt = jdbcTemplate.update(sql, params);
		
		if(cnt > 0) System.out.println("수정완료");
	}

	@Override
	public void removeGrade(int gno) {
		String sql="delete from sungjuk where sjno = ?";
		
		//Object[] params = new Object[] { gno };
		
		Object params = gno;
		
		int cnt = jdbcTemplate.update(sql,params);
		if (cnt > 0) System.out.println("데이터 삭제 완료");
	}
}
