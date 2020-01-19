package com.starter.animator.rest.api;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.starter.animator.beans.MasterDataBean;
import com.starter.animator.beans.RestResponse;
import com.starter.animator.manager.MasterDataManager;

@RestController
@RequestMapping(value = "masterData")
public class MasterDataWebService {

	@Resource
	private MasterDataManager masterDataManager;

	@GetMapping(headers = "version=v1")
	public ResponseEntity<RestResponse<MasterDataBean>> getMasterDataForApp(
			@RequestParam(name = "publisherId", required = false) String publisherId) {

		List<MasterDataBean> masterDataList = Collections.emptyList();

		if (StringUtils.isBlank(publisherId)) {
			masterDataList = this.masterDataManager.getMasterDataForApplication();
		} else {
			masterDataList = this.masterDataManager.getMasterDataForPublisher(publisherId);
		}

		return new ResponseEntity<>(new RestResponse<MasterDataBean>(masterDataList, masterDataList.size()),
				HttpStatus.OK);
	}

}
