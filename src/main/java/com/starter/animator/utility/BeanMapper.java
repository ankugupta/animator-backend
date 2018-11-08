package com.starter.animator.utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

@Component
public class BeanMapper {
	
	@Resource
	private DozerBeanMapper mapper;

	public <S, T> T map(S source, Class<T> targetType){
		
		if(source == null){
			return null;	
		}
		
		return this.mapper.map(source, targetType);
	}
	
	public <S, T> List<T> map(List<S> sourceList, Class<T> targetType){
		
		if(sourceList == null){
			return Collections.emptyList();
		}
		
		List<T> targetList = new ArrayList<>();

		for(S source: sourceList){
			targetList.add(this.mapper.map(source, targetType));
		}
		return targetList;
	}
}
