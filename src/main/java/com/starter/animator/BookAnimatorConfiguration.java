package com.starter.animator;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookAnimatorConfiguration {

	@Bean
	public DozerBeanMapper mapper() {
		return new DozerBeanMapper();
	}

}
