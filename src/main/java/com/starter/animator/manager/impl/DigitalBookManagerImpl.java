package com.starter.animator.manager.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.starter.animator.beans.DigitalBookBean;
import com.starter.animator.entity.DigitalBookEntity;
import com.starter.animator.exception.ErrorBean;
import com.starter.animator.exception.RestException;
import com.starter.animator.manager.DigitalBookManager;
import com.starter.animator.repository.DigitalBookRepository;
import com.starter.animator.utility.BeanMapper;

@Service
public class DigitalBookManagerImpl implements DigitalBookManager {

	@Autowired
	private DigitalBookRepository bookRepository;

	@Resource
	private BeanMapper beanMapper;

	@Override
	public DigitalBookBean getBookByAccessKey(String accessKey, String publisherId) throws RestException {
		DigitalBookEntity bookEntity = this.bookRepository.findByPublisherIdAndAccessKey(publisherId, accessKey);
		DigitalBookBean bookBean = this.mapToDigitalBookBean(bookEntity);
		if (bookBean == null) {
			throw new RestException(new ErrorBean("4000101", "error.book.not.found"), HttpStatus.NOT_FOUND);
		}

		return bookBean;
	}

	private DigitalBookBean mapToDigitalBookBean(DigitalBookEntity digitalBookEntity) {
		if (digitalBookEntity == null) {
			return null;
		}

		DigitalBookBean target = this.beanMapper.map(digitalBookEntity, DigitalBookBean.class);
		target.setImageUrl(digitalBookEntity.getResourceUrl().concat(target.getImageUrl()));
		target.setContentUrl(digitalBookEntity.getResourceUrl().concat(target.getContentUrl()));

		return target;
	}

	/*@Override
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
	}*/

	/*	private List<DigitalBookBean> mapToDigitalBookBeans(List<DigitalBookEntity> bookEntities) {
			if (bookEntities == null) {
				return Collections.emptyList();
			}
	
			List<DigitalBookBean> targetList = new ArrayList<>();
	
			for (DigitalBookEntity source : bookEntities) {
				DigitalBookBean target = this.beanMapper.map(source, DigitalBookBean.class);
				target.setImageUrl(source.getResourceUrl().concat(target.getImageUrl()));
				target.setContentUrl(source.getResourceUrl().concat(target.getContentUrl()));
				targetList.add(target);
			}
			return targetList;
		}*/

}
