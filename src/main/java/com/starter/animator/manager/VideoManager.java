package com.starter.animator.manager;

import java.util.List;

import com.starter.animator.beans.VideoBean;

public interface VideoManager {

	List<VideoBean> getVideoList(String publisherId);

}
