package com.starter.animator.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.starter.animator.entity.VideoEntity;

public interface VideoRepository extends MongoRepository<VideoEntity, String> {

	public List<VideoEntity> findByPublisherId(String publisherId);
}
