package lsj.spring.vo;

public class Member {
	protected int mno;
	protected String uid;
	protected String pwd;
	protected String name;
	protected String email;
	protected String regdate;
	
	public Member(String uid, String pwd, String name,String email) {
		this.uid = uid;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
	}
	
	public Member(int mno, String uid, String name, String regdate) {
		this.mno = mno;
		this.uid = uid;
		this.name = name;
		this.regdate = regdate;
	}

	public Member(String pwd, String name, String email) {
		this.pwd = pwd;
		this.name = name;
		this.email = email;
	}

	public Member(int mno, String uid, String pwd, String name, String email, String regdate) {
		this.mno = mno;
		this.uid = uid;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.regdate = regdate;
	}

	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "Member [mno=" + mno + ", uid=" + uid + ", pwd=" + pwd + ", name=" + name + ", email=" + email
				+ ", regdate=" + regdate + "]";
	}
	
	
	
}
