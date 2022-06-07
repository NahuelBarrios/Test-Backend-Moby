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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TechnologyServiceImp implements TechnologyService {
    @Autowired
    TechnologyRepository technologyRepository;

    @Override
    @Transactional
    public TechnologyDomain createTechnology(TechnologyDomain technologyDomain) {
        var technology = TechnologyMapper.mapDomainToModel(technologyDomain);
        technologyRepository.save(technology);
        return TechnologyMapper.mapModelToDomain(technology);
    }

    @Override
    @Transactional
    public TechnologyDomain updateTechnology(TechnologyDomain technologyDomain, Long id) throws TechnologyNotFoundException {
        Optional<Technology> technologyOptional = Optional.ofNullable(technologyRepository.findById(id)
                .orElseThrow(() -> new TechnologyNotFoundException("No se encontro el Id")));
        var technology = technologyOptional.get();
        technology.setNameTechnology(technologyDomain.getTechnology());
        return TechnologyMapper.mapModelToDomain(technologyRepository.save(technology));
    }

    @Override
    @Transactional
    public List<TechnologyDomain> findAll() {
        List<Technology> technologies = technologyRepository.findAll();
        return technologies.stream().map(TechnologyMapper::mapModelToDomain)
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
