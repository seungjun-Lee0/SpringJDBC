package lsj.spring.service;

import java.util.List;

import lsj.spring.vo.Book;

public interface BookService {
	void newBook();
	List<Book> readBook();
	void readOneBook(String bno);
	void modifyBook(Book b);
	void deleteBook(String bno);
}
