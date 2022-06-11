package com.example.systore.service.demand;

import com.example.systore.domain.dto.request.demand.SaveDemandDto;
import com.example.systore.domain.entity.Demand;
import com.example.systore.domain.repository.DemandRepository;
import com.example.systore.util.MenuUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class DemandServiceImpl implements DemandService {

    private final DemandRepository demandRepository;
    private final MenuUtils menuUtils;

    private static ModelMapper modelMapper = new ModelMapper();

    @Override
    @Transactional
    public Demand storeDemand(SaveDemandDto saveDemandDto) {
        Demand demand = Demand.builder()
                .status(saveDemandDto.getDemandStatus())
                .menus(menuUtils.getMenusListByIds(saveDemandDto.getMenuIds()))
                .build();
        return demandRepository.save(demand);
    }
}
