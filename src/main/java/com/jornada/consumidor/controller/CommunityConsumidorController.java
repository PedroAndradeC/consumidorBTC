package com.jornada.consumidor.controller;

import com.jornada.consumidor.dto.CommunityLogDTO;
import com.jornada.consumidor.service.CommunityLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/consumidor")
@RequiredArgsConstructor
public class CommunityConsumidorController {

    private final CommunityLogService communityLogService;

    public List<CommunityLogDTO> ListarLog() throws Exception {
        List<CommunityLogDTO> list = communityLogService.retornarListaLog();
        return list;
    }
}
