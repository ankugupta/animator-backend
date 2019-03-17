package com.starter.animator.manager;

import java.util.List;

import com.starter.animator.beans.EBookBean;

public interface EBookManager {

	List<EBookBean> getEBooks(String publisherId);

	List<EBookBean> getAllEBooks();
}
