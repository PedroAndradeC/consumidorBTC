package com.jornada.consumidor.entity;


import com.jornada.consumidor.dto.OperacaoCommunity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "comunidadeConsumidor")
@Getter
@Setter
public class CommunityLogEntity {

    private OperacaoCommunity operacaoCommunity;

    private String community;

    private Date horario;

    private String _class;
}
