package com.testback.controller.impl;

import com.testback.controller.TechnologyController;
import com.testback.domain.TechnologyDomain;
import com.testback.mapper.TechnologyMapper;
import com.testback.models.views.TechnologyDto;
import com.testback.models.views.TechnologyDtoCreateUpdate;
import com.testback.services.impl.TechnologyServiceImp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class TechnologyResource implements TechnologyController {

    private final TechnologyServiceImp technologyServiceImp;

    public TechnologyResource(TechnologyServiceImp technologyServiceImp) {
        this.technologyServiceImp = technologyServiceImp;
    }

    @Override
    public TechnologyDto createTechnology(TechnologyDtoCreateUpdate technologyDtoCreateUpdate) {
        TechnologyDomain technologyDomain = TechnologyMapper.mapCreateUpdateToDomain(technologyDtoCreateUpdate);
        return TechnologyMapper.mapDomainToDto(technologyServiceImp.createTechnology(technologyDomain));
    }

    @Override
    public TechnologyDto updateTechnology(TechnologyDtoCreateUpdate technologyDtoCreateUpdate, Long id) {
        TechnologyDomain technologyDomain = TechnologyMapper.mapCreateUpdateToDomain(technologyDtoCreateUpdate);
        return TechnologyMapper.mapDomainToDto(technologyServiceImp.updateTechnology(technologyDomain, id));
    }

    @Override
    public List<TechnologyDto> findAll() {
        return technologyServiceImp.findAll().stream()
                .map(TechnologyMapper::mapDomainToDto).collect(Collectors.toList());
    }

    @Override
    public void deleteTechnology(Long id) {
        technologyServiceImp.deleteTechnology(id);
    }
}
