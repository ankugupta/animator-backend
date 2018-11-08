package com.starter.animator.beans;

import java.util.ArrayList;
import java.util.List;

public class RestResponse<T> {

	private List<T> resources;
	private int count;
	
	public RestResponse(T resource, int count){
		List<T> resources = new ArrayList<>();
		resources.add(resource);
		this.resources = resources;
		this.count = count;
	}
	
	public RestResponse(List<T> resources, int count){
		this.resources = resources;
		this.count = count;
	}

	public List<T> getResources() {
		return resources;
	}

	public void setResources(List<T> resources) {
		this.resources = resources;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
