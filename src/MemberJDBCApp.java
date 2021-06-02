import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lsj.spring.service.MemberService;

public class MemberJDBCApp {
	
	public static void main(String args[]) {
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("springjdbc01.xml");
		
		MemberService msrv = (MemberService) ctx.getBean("msrv");
		
		//msrv.newMember("id", "passwd", "name", "name@email.com");
		
		//msrv.showAllMember();
		
		msrv.showOneMember(6);
		
		//msrv.modifyMember(6, "비밀번호","isfd", "fdsf");
		
		//msrv.deleteMember(1);
		}
}
