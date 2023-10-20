package com.jornada.consumidor.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jornada.consumidor.dto.CommunityLogDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConsumidorService {

    private final CommunityLogService communityLogService;

    @KafkaListener(
        groupId = "${kafka.group.id}",
        topicPartitions = {@TopicPartition(topic = "${kafka.topic}", partitions = {"0"})},
        containerFactory = "listenerContainerFactory",
        clientIdPrefix = "log-topic")
    public void consumir(
            @Payload String mensagem,
            @Header(KafkaHeaders.RECEIVED_KEY) String chave,
            @Header(KafkaHeaders.OFFSET) Long offset
    ) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); // Ignorar campos desconhecidos

        CommunityLogDTO dto;
        try {
            dto = objectMapper.readValue(mensagem, CommunityLogDTO.class);
            log.info("Descrição da comunidade: {} \n chave: {} \n offset: {}", dto, chave, offset);
            communityLogService.salvarMongoDB(dto);
        } catch (JsonProcessingException e) {
            log.error("Erro ao processar a mensagem JSON: " + e.getMessage());
        }
    }
}
