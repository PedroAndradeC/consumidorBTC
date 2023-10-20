package com.jornada.consumidor.repository;

import com.jornada.consumidor.entity.CommunityLogEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityLogRepository extends MongoRepository<CommunityLogEntity, String> {
}
