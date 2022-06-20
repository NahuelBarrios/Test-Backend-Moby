package com.testback.services.impl;

import com.testback.exception.TechnologyNotFoundException;
import com.testback.mapper.TechnologyMapper;
import com.testback.models.entities.Technology;
import com.testback.models.views.TechnologyDto;
import com.testback.models.views.TechnologyDtoCreateUpdate;
import com.testback.repository.TechnologyRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.testback.services.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TechnologyServiceImp implements TechnologyService {
    @Autowired
    TechnologyRepository technologyRepository;

    @Override
    @Transactional
    public TechnologyDto createTechnology(TechnologyDtoCreateUpdate technologyDtoCreateUpdate) {
        var technology = TechnologyMapper.mapCreateUpdateToModel(technologyDtoCreateUpdate);
        technologyRepository.save(technology);
        return TechnologyMapper.mapModelToDto(technology);
    }

    @Override
    @Transactional
    public TechnologyDto updateTechnology(TechnologyDtoCreateUpdate technologyDtoCreateUpdate, Long id) throws TechnologyNotFoundException {
        Optional<Technology> technologyOptional = Optional.ofNullable(technologyRepository.findById(id)
                .orElseThrow(() -> new TechnologyNotFoundException("No se encontro el Id")));
        var technology = technologyOptional.get();
        technology.setNameTechnology(technologyDtoCreateUpdate.getNameTechnology());
        return TechnologyMapper.mapModelToDto(technologyRepository.save(technology));
    }

    @Override
    @Transactional
    public List<TechnologyDto> findAll() {
        List<Technology> technologies = technologyRepository.findAll();
        return technologies.stream().map(TechnologyMapper::mapModelToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteTechnology(Long id) throws TechnologyNotFoundException {
        Optional<Technology> technologyOptional = Optional.ofNullable(technologyRepository.findById(id)
                .orElseThrow(() -> new TechnologyNotFoundException("No se encontro el Id")));
        technologyRepository.delete(technologyOptional.get());
    }
}
