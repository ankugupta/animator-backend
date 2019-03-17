package com.starter.animator.rest.api;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.starter.animator.beans.EBookBean;
import com.starter.animator.beans.RestResponse;
import com.starter.animator.manager.EBookManager;

@RestController
@RequestMapping(value = "publisher/{publisherId}/ebooks")
public class EBookWebService {

	@Resource
	private EBookManager eBookManager;

	@GetMapping(headers = "version=v1")
	public ResponseEntity<RestResponse<EBookBean>> getEBooks(@PathVariable String publisherId) {

		List<EBookBean> ebooks = this.eBookManager.getEBooks(publisherId);

		return new ResponseEntity<>(new RestResponse<EBookBean>(ebooks, ebooks.size()), HttpStatus.OK);
	}

}
