package com.starter.animator.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.starter.animator.entity.EBookEntity;

public interface EBookRepository extends MongoRepository<EBookEntity, String> {

	public List<EBookEntity> findByPublisherId(String publisherId);
}
