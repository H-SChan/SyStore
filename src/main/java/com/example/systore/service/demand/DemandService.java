package com.example.systore.service.demand;

import com.example.systore.domain.dto.request.demand.SaveDemandDto;
import com.example.systore.domain.entity.Demand;

import javax.transaction.Transactional;

public interface DemandService {
    @Transactional
    Demand storeDemand(SaveDemandDto saveDemandDto);
}
