package com.starter.animator.manager.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.starter.animator.beans.VideoBean;
import com.starter.animator.entity.VideoEntity;
import com.starter.animator.manager.VideoManager;
import com.starter.animator.repository.VideoRepository;
import com.starter.animator.utility.BeanMapper;

@Service
public class VideoManagerImpl implements VideoManager {

	@Resource
	private VideoRepository videoRepository;

	@Resource
	private BeanMapper beanMapper;

	@Override
	public List<VideoBean> getVideoList(String publisherId) {

		List<VideoEntity> videoEntities = this.videoRepository.findByPublisherId(publisherId);
		return this.mapToVideoBeans(videoEntities);
	}

	private List<VideoBean> mapToVideoBeans(List<VideoEntity> videoEntities) {
		if (videoEntities == null) {
			return Collections.emptyList();
		}

		List<VideoBean> targetList = new ArrayList<>();

		for (VideoEntity source : videoEntities) {
			VideoBean target = this.beanMapper.map(source, VideoBean.class);
			targetList.add(target);
		}
		return targetList;
	}

}
