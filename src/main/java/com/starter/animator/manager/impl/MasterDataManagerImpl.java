package com.starter.animator.manager.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.starter.animator.beans.MasterDataBean;
import com.starter.animator.entity.MasterDataEntity;
import com.starter.animator.manager.MasterDataManager;
import com.starter.animator.repository.MasterDataRepository;
import com.starter.animator.utility.BeanMapper;

@Service
public class MasterDataManagerImpl implements MasterDataManager {

	@Resource
	private MasterDataRepository masterDataRepository;

	@Resource
	private BeanMapper beanMapper;

	@Override
	public List<MasterDataBean> getMasterDataForPublisher(String publisherId) {

		List<MasterDataEntity> masterDataEntities = this.masterDataRepository.findByLevelAndPublisherId("PUBLISHER",
				publisherId);
		return this.mapToMasterDataBeans(masterDataEntities);
	}

	private List<MasterDataBean> mapToMasterDataBeans(List<MasterDataEntity> masterDataEntities) {
		if (masterDataEntities == null) {
			return Collections.emptyList();
		}

		List<MasterDataBean> targetList = new ArrayList<>();

		for (MasterDataEntity source : masterDataEntities) {
			MasterDataBean target = this.beanMapper.map(source, MasterDataBean.class);
			target.setData(source.getData());
			targetList.add(target);
		}
		return targetList;
	}

	@Override
	public List<MasterDataBean> getMasterDataForApplication() {
		List<MasterDataEntity> masterDataEntities = this.masterDataRepository.findByLevel("APPLICATION");
		return this.mapToMasterDataBeans(masterDataEntities);
	}

}
