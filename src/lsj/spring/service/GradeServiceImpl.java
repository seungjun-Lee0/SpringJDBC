package lsj.spring.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lsj.spring.dao.GradeDAO;
import lsj.spring.vo.Grade;

@Service("gsrv")
public class GradeServiceImpl implements GradeService {
	
	@Autowired
	private GradeDAO gdao;
	
	@Override
	public void newGrade() {
		Grade gd = new Grade("이름" , 64 ,34 ,34);
		computeGrade(gd);
		System.out.println("성적데이터 생성 완료");
		
		gdao.insertGrade(gd);
	}
	
	private void computeGrade(Grade gd) {
		int tot = gd.getKor() + gd.getEng() + gd.getMat();
		double avg = tot / 3.0; 
		String grd = "가";
		
		if (avg >= 90) grd = "수";
		else if (avg >= 80) grd = "우";
		else if (avg >= 70) grd = "미";
		else if (avg >= 60) grd = "양";
		
		gd.setTot(tot);
		gd.setAvg(avg);
		gd.setGrd(grd.charAt(0));
	}

	@Override
	public void readAllGrade() {
		StringBuffer sb = new StringBuffer();
		List<Grade> gds = gdao.selectAllGrade();
		for (Grade gd: gds) {
			sb.append(gd);
			System.out.println(gd);
		}		
	}

	@Override
	public void readOneGrade(int gno) {
		Grade gd = gdao.selectOneGrade(gno);
		System.out.println(gd);
	}

	@Override
	public void modifyGrade() {
		Grade gd = new Grade(null, 76,64,66);
		gd.setSjno("3");
		computeGrade(gd);
		
		gdao.updateGrade(gd);
	}

	@Override
	public void removeGrade() {
		gdao.removeGrade(5);
	}

}
