package com.jornada.consumidor.repository;

import com.jornada.consumidor.entity.CommunityLogEntity;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityRepository extends MongoRepository<CommunityLogEntity, String> {
}
