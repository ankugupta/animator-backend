package com.starter.animator.manager.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.starter.animator.beans.EBookBean;
import com.starter.animator.entity.EBookEntity;
import com.starter.animator.manager.EBookManager;
import com.starter.animator.repository.EBookRepository;
import com.starter.animator.utility.BeanMapper;

@Service
public class EBookManagerImpl implements EBookManager {

	@Resource
	private EBookRepository eBookRepository;

	@Resource
	private BeanMapper beanMapper;

	@Override
	public List<EBookBean> getEBooks(String publisherId) {

		List<EBookEntity> eBookEntities = this.eBookRepository.findByPublisherId(publisherId);
		return this.mapToBookBeans(eBookEntities);
	}

	@Override
	public List<EBookBean> getAllEBooks() {

		List<EBookEntity> eBookEntities = this.eBookRepository.findAll();
		return this.mapToBookBeans(eBookEntities);
	}

	private List<EBookBean> mapToBookBeans(List<EBookEntity> eBookEntities) {
		if (eBookEntities == null) {
			return Collections.emptyList();
		}

		List<EBookBean> targetList = new ArrayList<>();

		for (EBookEntity source : eBookEntities) {
			EBookBean target = this.beanMapper.map(source, EBookBean.class);
			target.setImageUrl(source.getResourceUrl().concat(target.getImageUrl()));
			target.setBookUrl(source.getResourceUrl().concat(target.getBookUrl()));
			targetList.add(target);
		}
		return targetList;
	}

}
