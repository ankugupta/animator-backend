package com.starter.animator.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.starter.animator.entity.PageEntity;

public interface PageRepository extends MongoRepository<PageEntity, String> {

	public List<PageEntity> findByBookId(String bookId);
}
