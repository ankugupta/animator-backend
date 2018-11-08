package com.starter.animator.manager;

import java.util.List;

import com.starter.animator.beans.BookBean;
import com.starter.animator.beans.BookRequestBean;

public interface BookManager {

	List<BookBean> getBooks(String publisherId);
	
	BookBean getBookById(String bookId, String publisherId);
	
	BookBean create(BookRequestBean book, String publisherId);

	List<BookBean> getAllBooks();
}
