package com.jornada.consumidor.service;

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
    ) {
        log.info("Mensagem recebida: {} \n chave: {} \n offset: {}", mensagem, chave, offset);
    }
}
