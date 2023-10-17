package com.jornada.consumidor.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jornada.consumidor.dto.CommunityDTO;
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
        topicPartitions = {@TopicPartition(topic = "${kafka.topic}", partitions = {"0", "1", "2"})},
        containerFactory = "listenerContainerFactory",
        clientIdPrefix = "log-topic")
    public void consumir(
            @Payload String mensagem,
            @Header(KafkaHeaders.RECEIVED_KEY) String chave,
            @Header(KafkaHeaders.OFFSET) Long offset
    ) throws JsonProcessingException {
        // String para Objeto
        CommunityLogDTO dto = new ObjectMapper().readValue(mensagem, CommunityLogDTO.class);
        log.info("Descrição da comunidade: {} \n chave: {} \n offset: {}", dto, chave, offset);

        communityLogService.salvarMongoDB(dto);
    }
}
