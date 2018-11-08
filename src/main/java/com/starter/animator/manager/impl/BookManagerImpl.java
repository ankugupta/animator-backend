package com.starter.animator.manager.impl;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starter.animator.beans.BookBean;
import com.starter.animator.beans.BookRequestBean;
import com.starter.animator.entity.BookEntity;
import com.starter.animator.manager.BookManager;
import com.starter.animator.repository.BookRepository;
import com.starter.animator.utility.BeanMapper;

@Service
public class BookManagerImpl implements BookManager {

	@Autowired
	private BookRepository bookRepository;
	
	@Resource
	private BeanMapper beanMapper;
	
	@Override
	public List<BookBean> getBooks(String publisherId) {
		
		List<BookEntity> bookEntities = this.bookRepository.findByPublisherId(publisherId);
		return this.beanMapper.map(bookEntities, BookBean.class);
	}
	
	@Override
	public List<BookBean> getAllBooks(){
		List<BookEntity> books = this.bookRepository.findAll();
		return this.beanMapper.map(books, BookBean.class);
	}

	@Override
	public BookBean getBookById(String bookId, String publisherId) {

		Optional<BookEntity> bookEntityOptional = this.bookRepository.findById(bookId);
		BookBean bookBean = null;
		if(bookEntityOptional.isPresent()){
			bookBean = this.beanMapper.map(bookEntityOptional.get(), BookBean.class);
		}
		return bookBean;
	}

	@Override
	public BookBean create(BookRequestBean book, String publisherId){
		BookEntity newBook = this.beanMapper.map(book, BookEntity.class);
		BookEntity result = this.bookRepository.save(newBook);
		return this.beanMapper.map(result, BookBean.class);
	}

}
