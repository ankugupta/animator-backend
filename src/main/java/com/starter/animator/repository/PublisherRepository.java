package com.starter.animator.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.starter.animator.entity.PublisherEntity;

public interface PublisherRepository extends MongoRepository<PublisherEntity, String> {

	public PublisherEntity findByPublisherId(String publisherId);
}
