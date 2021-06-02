import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lsj.spring.service.MemberService;

public class MemberJDBCApp02 {
	
	public static void main(String args[]) {
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("springjdbc03.xml");
		
		MemberService msrv = (MemberService) ctx.getBean("msrv02");
		
		//msrv.newMember("id123", "passwd", "name", "name@email.com");
		
		//msrv.showAllMember();
		
		//msrv.showOneMember(6);
		
		//msrv.modifyMember(6, "수정됨","isfd123", "fdsf123");
		
		msrv.deleteMember(6);
		}
}
