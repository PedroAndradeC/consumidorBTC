package com.jornada.consumidor.mapper;

import com.jornada.consumidor.dto.CommunityLogDTO;
import com.jornada.consumidor.entity.CommunityLogEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommunityLogMapper {
    CommunityLogEntity toEntity(CommunityLogDTO dto);

    CommunityLogDTO toDTO(CommunityLogEntity entity);
}
