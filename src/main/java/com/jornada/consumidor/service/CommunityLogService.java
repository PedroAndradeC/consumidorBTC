package com.jornada.consumidor.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jornada.consumidor.dto.CommunityLogDTO;
import com.jornada.consumidor.entity.CommunityLogEntity;
import com.jornada.consumidor.mapper.CommunityLogMapper;
import com.jornada.consumidor.repository.CommunityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CommunityLogService {
    private CommunityLogMapper communityLogMapper;
    private CommunityRepository communityRepository;
    private ObjectMapper objectMapper;

    public void salvarMongoDB(CommunityLogDTO communityLogDTO) throws JsonProcessingException {
        try {
            String communityLogJson = objectMapper.writeValueAsString(communityLogDTO);
            CommunityLogEntity communityLogEntity = communityLogMapper.toEntity(communityLogDTO);
            communityRepository.save(communityLogEntity);
            log.info("Log da comunidade salvo no MongoDB com sucesso");
        } catch (JsonProcessingException e) {
            log.error("Erro ao processar JSON: " + e.getMessage());
        }
    }
}
