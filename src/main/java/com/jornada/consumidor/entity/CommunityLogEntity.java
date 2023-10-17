package com.jornada.consumidor.entity;


import com.jornada.consumidor.dto.CommunityDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CommunityLogEntity {

    private CommunityDTO communityDTO;
    private Date horario;
}
