package com.starter.animator.rest.api;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.starter.animator.beans.RestResponse;
import com.starter.animator.beans.VideoBean;
import com.starter.animator.manager.VideoManager;

@RestController
@RequestMapping(value = "publisher/{publisherId}/videos")
public class VideosWebService {

	@Resource
	private VideoManager videoManager;

	@GetMapping(headers = "version=v1")
	public ResponseEntity<RestResponse<VideoBean>> getVideoList(@PathVariable String publisherId) {

		List<VideoBean> videos = this.videoManager.getVideoList(publisherId);

		return new ResponseEntity<>(new RestResponse<VideoBean>(videos, videos.size()), HttpStatus.OK);
	}

}
