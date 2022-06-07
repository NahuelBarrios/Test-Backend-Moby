package com.testback.controller.impl;

import com.testback.controller.TechnologyController;
import com.testback.mapper.TechnologyMapper;
import com.testback.models.views.TechnologyDto;
import com.testback.models.views.TechnologyDtoCreateUpdate;
import com.testback.services.impl.TechnologyServiceImp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TechnologyResource implements TechnologyController {

    @Autowired
    TechnologyServiceImp technologyServiceImp;

    @Override
    public ResponseEntity<TechnologyDto> createTechnology(TechnologyDtoCreateUpdate technologyDtoCreateUpdate) {
        var technologyDomain = TechnologyMapper.mapCreateUpdateToDomain(technologyDtoCreateUpdate);
        var technologyDto = TechnologyMapper.mapDomainToDto(technologyServiceImp.createTechnology(technologyDomain));
        return new ResponseEntity<>(technologyDto, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<TechnologyDto> updateTechnology(TechnologyDtoCreateUpdate technologyDtoCreateUpdate, Long id) {
        var technologyDomain = TechnologyMapper.mapCreateUpdateToDomain(technologyDtoCreateUpdate);
        var technologyDto = TechnologyMapper.mapDomainToDto(technologyServiceImp.updateTechnology(technologyDomain, id));
        return new ResponseEntity<>(technologyDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<TechnologyDto>> findAll() {
        var technologies = technologyServiceImp.findAll().stream()
                .map(TechnologyMapper::mapDomainToDto).collect(Collectors.toList());
        return new ResponseEntity<>(technologies, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HttpStatus> deleteTechnology(Long id) {
        technologyServiceImp.deleteTechnology(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
