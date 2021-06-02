package lsj.spring.dao;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import lsj.spring.vo.Grade;

@Repository("gdao02")
public class GradeDAOImpl02 implements GradeDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insertGrade(Grade gd) {
		int cnt = sqlSession.insert("grade.insertGrade", gd);
		if (cnt>0) System.out.println("회원 등록성공!");
	}

	@Override
	public List<Grade> selectAllGrade() {
		
		return sqlSession.selectList("grade.selectGrade");
	}
	
	

	@Override
	public Grade selectOneGrade(int gno) {
		
		return sqlSession.selectOne("grade.selectOneGrade", gno);
	}
	
	
		
	

	@Override
	public void updateGrade(Grade gd) {
		int cnt = sqlSession.update("grade.updateGrade", gd);
		if (cnt>0) System.out.println("수정완료");
	}

	@Override
	public void removeGrade(int gno) {
		int cnt = sqlSession.delete("grade.deleteGrade", gno);
		if (cnt>0) System.out.println("삭제완료");
	}
}
