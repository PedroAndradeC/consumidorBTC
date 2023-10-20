package com.jornada.consumidor.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jornada.consumidor.dto.CommunityLogDTO;
import com.jornada.consumidor.entity.CommunityLogEntity;
import com.jornada.consumidor.mapper.CommunityLogMapper;
import com.jornada.consumidor.repository.CommunityLogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CommunityLogService {
    private final CommunityLogMapper communityLogMapper;
    private final CommunityLogRepository communityLogRepository;

    public void salvarMongoDB(CommunityLogDTO logDTO) throws JsonProcessingException {
        try {
            CommunityLogDTO communityLogDTO = new CommunityLogDTO();

            String communityLogJson = new ObjectMapper().writeValueAsString(logDTO.getCommunityDTO());

            communityLogDTO.setOperacaoCommunity(logDTO.getOperacaoCommunity());
            communityLogDTO.setHorario(logDTO.getHorario());
            communityLogDTO.setCommunityDTO(communityLogJson);

            CommunityLogEntity communityLogEntity = communityLogMapper.toEntity(communityLogDTO);
            communityLogRepository.save(communityLogEntity);
            log.info("Log da comunidade salvo no MongoDB com sucesso");
        } catch (JsonProcessingException e) {
            log.error("Erro ao processar JSON: " + e.getMessage());
        }
    }

    public List<CommunityLogDTO> retornarListaLog() throws Exception {
        List<CommunityLogEntity> listLog = communityLogRepository.findAll();
        List<CommunityLogDTO> listLogDTO = listLog.stream().map(entity -> communityLogMapper.toDTO(entity)).toList();
        return listLogDTO;
    }
}
