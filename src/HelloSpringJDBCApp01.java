import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lsj.spring.service.GradeService;

public class HelloSpringJDBCApp01 {
	
	// main -> service -> DAO

	public static void main(String[] args) {
		ApplicationContext ctx=
				new ClassPathXmlApplicationContext("springjdbc01.xml");
		
		GradeService gsrv = (GradeService) ctx.getBean("gsrv");
		
		// 성적 데이터 생성 후 디비에 저장
		// gsrv.newGrade();
		
		// 성적 데이터 조회
		//gsrv.readAllGrade();
		
		// 성적 데이터 상세 조회
		//gsrv.readOneGrade(3);
		
		// 성적 데이터 수정
		// gsrv.modifyGrade();
		
		// 성적 데이트 삭제
		gsrv.removeGrade();
	}
}
