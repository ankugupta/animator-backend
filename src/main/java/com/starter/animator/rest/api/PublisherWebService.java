package com.starter.animator.rest.api;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.starter.animator.beans.PublisherBean;
import com.starter.animator.beans.RestResponse;
import com.starter.animator.exception.RestException;
import com.starter.animator.manager.PublisherManager;

@RestController
@RequestMapping(value="publisher")
public class PublisherWebService {
	
	@Resource 
	private PublisherManager publisherManager;

	@GetMapping(headers="version=v1")
	public ResponseEntity<RestResponse<PublisherBean>> getAllPublishers() {
		List<PublisherBean> publishers = this.publisherManager.getAllPublishers();
		RestResponse<PublisherBean> response = new RestResponse<>(publishers, publishers.size());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping(value="/{publisherId}", headers="version=v1")
	public ResponseEntity<PublisherBean> getPublisherById(@PathVariable("publisherId") String publisherId) throws RestException {

		return new ResponseEntity<>(this.publisherManager.getPublisherById(publisherId), HttpStatus.OK);
	}
	
}
