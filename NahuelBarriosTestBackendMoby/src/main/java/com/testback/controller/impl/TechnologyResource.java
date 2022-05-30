package com.testback.controller.impl;

import com.testback.controller.TechnologyController;
import com.testback.domain.TechnologyDomain;
import com.testback.mapper.TechnologyMapper;
import com.testback.models.views.TechnologyDto;
import com.testback.models.views.TechnologyDtoCreateUpdate;
import com.testback.services.TechnologyService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TechnologyResource implements TechnologyController {

    private final TechnologyService technologyService;

    public TechnologyResource(TechnologyService technologyService){
        this.technologyService = technologyService;
    }

    @Override
    public TechnologyDto createTechnology(TechnologyDtoCreateUpdate technologyDtoCreateUpdate) {
        TechnologyDomain technologyDomain = TechnologyMapper.mapCreateUpdateToDomain(technologyDtoCreateUpdate);
        return TechnologyMapper.mapDomainToDto(technologyService.createTechnology(technologyDomain));
    }

    @Override
    public TechnologyDto updateTechnology(TechnologyDtoCreateUpdate technologyDtoCreateUpdate, Long id) {
        TechnologyDomain technologyDomain = TechnologyMapper.mapCreateUpdateToDomain(technologyDtoCreateUpdate);
        return TechnologyMapper.mapDomainToDto(technologyService.updateTechnology(technologyDomain,id));
    }

    @Override
    public List<TechnologyDto> findAll() {
        return technologyService.findAll().stream()
                .map(TechnologyMapper::mapDomainToDto).collect(Collectors.toList());
    }

    @Override
    public void deleteTechnology(Long id) {
        technologyService.deleteTechnology(id);
    }
}
