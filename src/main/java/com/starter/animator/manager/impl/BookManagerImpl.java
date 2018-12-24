package com.starter.animator.manager.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.starter.animator.beans.BookBean;
import com.starter.animator.beans.BookRequestBean;
import com.starter.animator.beans.PageBean;
import com.starter.animator.entity.BookEntity;
import com.starter.animator.entity.PageEntity;
import com.starter.animator.exception.ErrorBean;
import com.starter.animator.exception.RestException;
import com.starter.animator.manager.BookManager;
import com.starter.animator.repository.BookRepository;
import com.starter.animator.repository.PageRepository;
import com.starter.animator.utility.BeanMapper;

@Service
public class BookManagerImpl implements BookManager {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private PageRepository pageRepository;

	@Resource
	private BeanMapper beanMapper;

	@Override
	public List<BookBean> getBooks(String publisherId) {

		List<BookEntity> bookEntities = this.bookRepository.findByPublisherId(publisherId);
		return this.mapToBookBeans(bookEntities);
	}

	@Override
	public List<BookBean> getAllBooks() {
		List<BookEntity> books = this.bookRepository.findAll();
		return this.mapToBookBeans(books);
	}

	@Override
	public BookBean getBookById(String bookId, String publisherId) throws RestException {

		BookEntity bookEntity = this.bookRepository.findByBookId(bookId);
		BookBean bookBean = this.mapToBookBean(bookEntity);
		if (bookBean == null) {
			throw new RestException(new ErrorBean("4000101", "error.book.not.found"), HttpStatus.NOT_FOUND);
		}
		List<PageEntity> pageEntityList = this.pageRepository.findByBookId(bookId);
		bookBean.setPages(this.mapToPageBeans(pageEntityList, bookEntity.getResourceUrl()));

		return bookBean;
	}

	private List<BookBean> mapToBookBeans(List<BookEntity> bookEntities) {
		if (bookEntities == null) {
			return Collections.emptyList();
		}

		List<BookBean> targetList = new ArrayList<>();

		for (BookEntity source : bookEntities) {
			BookBean target = this.beanMapper.map(source, BookBean.class);
			target.setImageUrl(source.getResourceUrl().concat(target.getImageUrl()));
			target.setTargetDATUrl(source.getResourceUrl().concat(target.getTargetDATUrl()));
			target.setTargetXMLUrl(source.getResourceUrl().concat(target.getTargetXMLUrl()));
			targetList.add(target);
		}
		return targetList;
	}

	private BookBean mapToBookBean(BookEntity bookEntity) {
		if (bookEntity == null) {
			return null;
		}

		BookBean target = this.beanMapper.map(bookEntity, BookBean.class);
		target.setImageUrl(bookEntity.getResourceUrl().concat(target.getImageUrl()));
		target.setTargetDATUrl(bookEntity.getResourceUrl().concat(target.getTargetDATUrl()));
		target.setTargetXMLUrl(bookEntity.getResourceUrl().concat(target.getTargetXMLUrl()));

		return target;
	}

	private List<PageBean> mapToPageBeans(List<PageEntity> pageEntities, String bookResourceUrl) {
		if (pageEntities == null) {
			return Collections.emptyList();
		}

		List<PageBean> targetList = new ArrayList<>();

		for (PageEntity source : pageEntities) {
			PageBean target = this.beanMapper.map(source, PageBean.class);
			target.setImageUrl(bookResourceUrl.concat(target.getImageUrl()));
			target.setContentUrl(bookResourceUrl.concat(target.getContentUrl()));
			targetList.add(target);
		}
		return targetList;
	}

	private PageBean mapToPageBean(PageEntity pageEntity, String bookResourceUrl) {
		if (pageEntity == null) {
			return null;
		}

		PageBean target = this.beanMapper.map(pageEntity, PageBean.class);
		target.setImageUrl(bookResourceUrl.concat(target.getImageUrl()));
		target.setContentUrl(bookResourceUrl.concat(target.getContentUrl()));

		return target;
	}

	// !!!!IMPORTANT - this code is not functional
	@Override
	public BookBean create(BookRequestBean book, String publisherId) {
		BookEntity newBook = this.beanMapper.map(book, BookEntity.class);
		BookEntity result = this.bookRepository.save(newBook);
		return this.mapToBookBean(result);
	}
}
