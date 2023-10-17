package com.jornada.consumidor.repository;

import com.jornada.consumidor.entity.CommunityLogEntity;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface CommunityRepository extends MongoRepository<CommunityLogEntity, String> {
}
