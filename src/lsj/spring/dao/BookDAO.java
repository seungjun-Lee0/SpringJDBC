package lsj.spring.dao;

import java.util.List;

import lsj.spring.vo.Book;

public interface BookDAO {
	
	int insertBook(Book b);
	List<Book> selectBook();
	Book selectOneBook(String bid);
	int modifyBook(Book b);
	int deleteBook(String bid);
}
