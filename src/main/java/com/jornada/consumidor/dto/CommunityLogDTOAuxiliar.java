package com.jornada.consumidor.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CommunityLogDTOAuxiliar {

    private String idCommunity;
    private OperacaoCommunity operacaoCommunity;
    private CommunityLogDTO communityDTO;
    private Date horario;


}
