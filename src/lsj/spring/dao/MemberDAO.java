package lsj.spring.dao;

import java.util.List;

import lsj.spring.vo.Member;

public interface MemberDAO {

	void insertMember(Member mb);

	List<Member> selectAllMember();

	Member selectOneMember(int mno);

	void updateMember(Member mb);

	void removeMember(int mno);

}
