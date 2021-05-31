import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lsj.spring.service.MemberService;

public class HelloSpringJDBCApp02 {
	
	public static void main(String args[]) {
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("springjdbc02.xml");
		
		MemberService msrv = (MemberService) ctx.getBean("msrv");
		
		//msrv.newMember();
		
		//msrv.showAllMember();
		
		//msrv.showOneMember(1);
		
		//msrv.modifyMember(5);
		
		//msrv.deleteMember(1);
		}
}
