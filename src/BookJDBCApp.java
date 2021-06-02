import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lsj.spring.service.BookService;

public class BookJDBCApp {
	public static void main(String args[]) {
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("springjdbc03.xml");
		
		BookService bs = (BookService) ctx.getBean("bsrv02");
		
		bs.newBook();
				
	}
}
