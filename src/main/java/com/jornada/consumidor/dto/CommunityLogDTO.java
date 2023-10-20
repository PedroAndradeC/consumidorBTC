package com.jornada.consumidor.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CommunityLogDTO {

    private String idCommunity;
    private OperacaoCommunity operacaoCommunity;
    private String communityDTO;
    private Date horario;
}
