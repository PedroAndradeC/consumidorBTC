package com.jornada.consumidor.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jornada.consumidor.dto.CommunityDTO;
import com.jornada.consumidor.dto.PostDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumidorService {

    @KafkaListener(topics = "${kafka.topic}",
        groupId = "${kafka.group.id}",
        containerFactory = "listenerContainerFactory",
        clientIdPrefix = "primeiroTopico")
    public void consumir(
            @Payload String mensagem,
            @Header(KafkaHeaders.RECEIVED_KEY) String chave,
            @Header(KafkaHeaders.OFFSET) Long offset
    ) throws JsonProcessingException {
        // String para Objeto
        CommunityDTO dto = new ObjectMapper().readValue(mensagem, CommunityDTO.class);
        log.info("Mensagem recebida: {} \n chave: {} \n offset: {}", dto, chave, offset);
    }
}
