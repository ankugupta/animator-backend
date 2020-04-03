package com.starter.animator.manager;

import java.util.List;

import com.starter.animator.beans.DigitalBookBean;
import com.starter.animator.exception.RestException;

public interface DigitalBookManager {

	//List<DigitalBookBean> getDigitalBooks(String publisherId);

	//DigitalBookBean getBookById(String bookId, String publisherId) throws RestException;
	
	DigitalBookBean getBookByAccessKey(String accessKey, String publisherId) throws RestException;

}
