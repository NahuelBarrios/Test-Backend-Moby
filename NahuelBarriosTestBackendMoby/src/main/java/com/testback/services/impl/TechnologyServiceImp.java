package com.testback.services.impl;

import com.testback.domain.TechnologyDomain;
import com.testback.exception.TechnologyNotFoundException;
import com.testback.mapper.TechnologyMapper;
import com.testback.models.entities.Technology;
import com.testback.repository.TechnologyRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.testback.services.TechnologyService;
import org.springframework.transaction.annotation.Transactional;

public class TechnologyServiceImp implements TechnologyService {

    private final TechnologyRepository technologyRepository;

    public TechnologyServiceImp(TechnologyRepository technologyRepository) {
        this.technologyRepository = technologyRepository;
    }

    @Override
    public TechnologyDomain createTechnology(TechnologyDomain technologyDomain) {
        Technology technology = TechnologyMapper.mapDomainToModel(technologyDomain);
        technologyRepository.save(technology);
        return TechnologyMapper.mapModelToDomain(technology);
    }

    @Override
    public TechnologyDomain updateTechnology(TechnologyDomain technologyDomain, Long id) throws TechnologyNotFoundException {
        Optional<Technology> technologyOptional = Optional.ofNullable(technologyRepository.findById(id)
                .orElseThrow(() -> new TechnologyNotFoundException("No se encontro el Id")));
        Technology technology = technologyOptional.get();
        technology.setTechnology(technologyDomain.getTechnology());
        return TechnologyMapper.mapModelToDomain(technologyRepository.save(technology));
    }

    @Override
    public List<TechnologyDomain> findAll() {
        List<Technology> technologies = technologyRepository.findAll();
        return technologies.stream().map(TechnologyMapper::mapModelToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteTechnology(Long id) throws TechnologyNotFoundException {
        Optional<Technology> technologyOptional = Optional.ofNullable(technologyRepository.findById(id)
                .orElseThrow(() -> new TechnologyNotFoundException("No se encontro el Id")));
        technologyRepository.delete(technologyOptional.get());
    }
}
