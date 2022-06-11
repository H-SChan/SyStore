package com.example.systore.controller;

import com.example.systore.domain.dto.request.demand.SaveDemandDto;
import com.example.systore.domain.dto.response.Response;
import com.example.systore.service.demand.DemandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/demands")
@RestController
public class DemandController {

    private final DemandService demandService;

    @PostMapping
    public Response setDemand(SaveDemandDto saveDemandDto) {
        demandService.storeDemand(saveDemandDto);

        return new Response();
    }
}
