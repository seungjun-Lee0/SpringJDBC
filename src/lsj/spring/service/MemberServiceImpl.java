package lsj.spring.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lsj.spring.dao.MemberDAO;
import lsj.spring.vo.Member;

@Service("msrv")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO mdao;
	
	@Override
	public void newMember(String id, String passwd, String name, String email) {
		Member mb = new Member(id, passwd, name, email);
		System.out.println("멤버데이터 생성 완료");
		
		mdao.insertMember(mb);
	}

	@Override
	public void showAllMember() {
		StringBuffer sb = new StringBuffer();
		List<Member> mbs = mdao.selectAllMember();
		for (Member mb : mbs) {
			sb.append(mb);
			System.out.println(mb);
		}
	}

	@Override
	public void showOneMember(int mno) {
		Member mb = mdao.selectOneMember(mno);
		
		System.out.println(mb);
	}

	@Override
	public void modifyMember(int mno, String passwd, String name, String email) {
		Member mb = new Member(passwd, name, email);
		mb.setMno(mno);
		
		mdao.updateMember(mb);
	}

	@Override
	public void deleteMember(int mno) {
		mdao.removeMember(mno);
	}

}
