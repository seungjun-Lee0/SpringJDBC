package lsj.spring.dao;


import java.util.List;

import lsj.spring.vo.Grade;

public interface GradeDAO {
	void insertGrade(Grade gd);

	List<Grade> selectAllGrade();

	Grade selectOneGrade(int gno);

	void updateGrade(Grade gd);

	void removeGrade(int gno);
}
