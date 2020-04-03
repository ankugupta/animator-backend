package com.starter.animator.rest.api;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.starter.animator.beans.DigitalBookBean;
import com.starter.animator.exception.RestException;
import com.starter.animator.manager.DigitalBookManager;

@RestController
@RequestMapping(value = "publisher/{publisherId}/digitalbooks")
public class DigitalBookWebService {

	@Resource
	private DigitalBookManager digitalBookManager;

	@GetMapping(headers = "version=v1")
	public ResponseEntity<DigitalBookBean> getDigitalBookByKey(@PathVariable String publisherId,
			@RequestParam(name = "accessKey") String accessKey) throws RestException {
		DigitalBookBean digitalBookBean = this.digitalBookManager.getBookByAccessKey(accessKey, publisherId);
		return new ResponseEntity<>(digitalBookBean, HttpStatus.OK);
	}

}
