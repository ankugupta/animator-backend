package com.starter.animator.manager.impl;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.starter.animator.beans.PublisherBean;
import com.starter.animator.entity.PublisherEntity;
import com.starter.animator.exception.ErrorBean;
import com.starter.animator.exception.RestException;
import com.starter.animator.manager.PublisherManager;
import com.starter.animator.repository.PublisherRepository;
import com.starter.animator.utility.BeanMapper;

@Service
public class PublisherManagerImpl implements PublisherManager {

	@Autowired
	private PublisherRepository publisherRepository;
	
	@Resource
	private BeanMapper beanMapper;
	
	
	@Override
	public List<PublisherBean> getAllPublishers(){
		List<PublisherEntity> publishers = this.publisherRepository.findAll();
		return this.beanMapper.map(publishers, PublisherBean.class);
	}

	@Override
	public PublisherBean getPublisherById(String publisherId) throws RestException{

		Optional<PublisherEntity> publisherEntityOptional = this.publisherRepository.findById(publisherId);
		if(publisherEntityOptional.isPresent()){
			return this.beanMapper.map(publisherEntityOptional.get(), PublisherBean.class);
		}
		
		throw new RestException(new ErrorBean("4000201", "error.publisher.not.found"), HttpStatus.NOT_FOUND);
	}

}
