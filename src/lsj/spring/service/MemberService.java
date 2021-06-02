package lsj.spring.service;

public interface MemberService {

	void newMember(String id, String passwd, String name, String email);

	void showAllMember();

	void showOneMember(int mno);

	void modifyMember(int mno, String passwd, String name, String email);

	void deleteMember(int mno);

}
