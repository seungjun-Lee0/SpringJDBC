package lsj.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import lsj.spring.vo.Member;

@Repository("mdao02")
public class MemberDAOImpl02 implements MemberDAO{

	@Autowired
	private SqlSession sqlSession; 
	
	@Override
	public void insertMember(Member mb) {
		int cnt = sqlSession.insert("member.insertMember", mb);
		if(cnt>0) System.out.println("멤버 추가 완료");
	}

	@Override
	public List<Member> selectAllMember() {
		return sqlSession.selectList("member.selectMember");
	}
	

	@Override
	public Member selectOneMember(int mno) {
		
		return sqlSession.selectOne("member.selectOneMember", mno);
	}
	

	@Override
	public void updateMember(Member mb) {
		int cnt = sqlSession.update("member.updateMember", mb);
		if (cnt>0) System.out.println("수정완료");
		
	}

	@Override
	public void removeMember(int mno) {
		int cnt = sqlSession.delete("member.deleteMember",mno);
		if (cnt>0) System.out.println("삭제완료");
	}

}
