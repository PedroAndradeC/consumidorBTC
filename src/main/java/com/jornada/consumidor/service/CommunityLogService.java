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

import java.sql.SQLException;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CommunityLogService {
    private final CommunityLogMapper communityLogMapper;
    private final CommunityRepository communityRepository;
    private final ObjectMapper objectMapper;

    public void salvarMongoDB(CommunityLogDTO communityLogDTO) throws JsonProcessingException {
        try {
//            String communityLogJson = objectMapper.writeValueAsString(communityLogDTO);
//            CommunityLogEntity communityLogEntity = communityLogMapper.toEntity(communityLogDTO);
            CommunityLogEntity communityLogEntity = new CommunityLogEntity();
            String communityDto = objectMapper.writeValueAsString(communityLogDTO.getCommunityDTO());

//            CommunityLogEntity communityLogEntity = new CommunityLogEntity();
//            communityLogEntity.setNameCommunity(communityLogDTO.getNameCommunity());
//            communityLogEntity.setCommunityTopic(communityLogDTO.getCommunityTopic());
//            communityLogEntity.setDescriptionCommunity(communityLogDTO.getDescriptionCommunity());

            communityLogDTO.setDescriptionCommunity(communityLogDTO.getDescriptionCommunity());
            communityLogDTO.setHorario(communityLogDTO.getHorario());
            communityLogDTO.setCommunityDTO(communityLogDTO.getCommunityDTO());

            communityLogEntity = communityLogMapper.toEntity(communityLogDTO);
            communityRepository.save(communityLogEntity);
            log.info("Log da comunidade salvo no MongoDB com sucesso");
//        } catch (JsonProcessingException e) {
//            log.error("Erro ao processar JSON: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
