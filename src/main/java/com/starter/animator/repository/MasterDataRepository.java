package com.starter.animator.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.starter.animator.entity.MasterDataEntity;

public interface MasterDataRepository extends MongoRepository<MasterDataEntity, String> {

	public List<MasterDataEntity> findByLevelAndPublisherId(String level, String publisherId);

	public List<MasterDataEntity> findByLevel(String level);

}
