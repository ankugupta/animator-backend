package com.starter.animator.manager;

import java.util.List;

import com.starter.animator.beans.BookBean;
import com.starter.animator.beans.BookRequestBean;
import com.starter.animator.exception.RestException;

public interface BookManager {

	List<BookBean> getBooks(String publisherId);
	
	BookBean getBookById(String bookId, String publisherId) throws RestException;
	
	BookBean create(BookRequestBean book, String publisherId);

	List<BookBean> getAllBooks();
}
