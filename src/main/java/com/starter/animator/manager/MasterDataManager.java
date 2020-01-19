package com.starter.animator.manager;

import java.util.List;

import com.starter.animator.beans.MasterDataBean;

public interface MasterDataManager {

	List<MasterDataBean> getMasterDataForPublisher(String publisherId);

	List<MasterDataBean> getMasterDataForApplication();
}
