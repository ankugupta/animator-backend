package com.starter.animator.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.starter.animator.entity.DigitalBookEntity;

public interface DigitalBookRepository extends MongoRepository<DigitalBookEntity, String> {

	public List<DigitalBookEntity> findByPublisherId(String publisherId);

	public DigitalBookEntity findByBookId(String bookId);

	public DigitalBookEntity findByPublisherIdAndAccessKey(String publisherId, String accessKey);
}
