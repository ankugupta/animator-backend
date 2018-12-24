package com.starter.animator.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.starter.animator.entity.BookEntity;

public interface BookRepository extends MongoRepository<BookEntity, String> {

	public List<BookEntity> findByPublisherId(String publisherId);
	public BookEntity findByBookId(String bookId);
}
