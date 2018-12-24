package com.starter.animator.manager;

import java.util.List;

import com.starter.animator.beans.PublisherBean;
import com.starter.animator.exception.RestException;

public interface PublisherManager {

	PublisherBean getPublisherById(String publisherId) throws RestException;

	List<PublisherBean> getAllPublishers();
}
