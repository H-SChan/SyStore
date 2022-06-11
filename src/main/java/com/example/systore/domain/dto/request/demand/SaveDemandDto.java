package com.example.systore.domain.dto.request.demand;

import com.example.systore.enums.DemandStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class SaveDemandDto {

    private DemandStatus demandStatus = DemandStatus.DOING;
    private List<Long> menuIds;

}
