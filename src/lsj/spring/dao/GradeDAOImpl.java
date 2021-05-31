package lsj.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
}
