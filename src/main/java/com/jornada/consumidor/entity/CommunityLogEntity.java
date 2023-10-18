package com.jornada.consumidor.entity;


import com.jornada.consumidor.dto.CommunityDTO;
import com.jornada.consumidor.dto.DescriptionCommunity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "comunidadeConsumidor")
@Getter
@Setter
public class CommunityLogEntity {

    private DescriptionCommunity descriptionCommunity;

    private String community;

    private Date horario;

    private String _class;
}
