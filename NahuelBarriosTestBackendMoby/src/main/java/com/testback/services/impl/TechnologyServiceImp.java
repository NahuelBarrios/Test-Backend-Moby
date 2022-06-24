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
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
public class TechnologyServiceImp implements TechnologyService {
    @Autowired
    TechnologyRepository technologyRepository;

    private static final String TECHNOLOGY_NOT_FOUND = "No se encontro el Id";

    @Override
    @Transactional
    public TechnologyDto createTechnology(TechnologyDtoCreateUpdate technologyDtoCreateUpdate) {
        var technology = TechnologyMapper.mapCreateUpdateToModel(technologyDtoCreateUpdate);
        technologyRepository.save(technology);
        log.info("Se creo la tecnologia con exito");
        return TechnologyMapper.mapModelToDto(technology);
    }

    @Override
    @Transactional
    public TechnologyDto updateTechnology(TechnologyDtoCreateUpdate technologyDtoCreateUpdate, Long id) throws TechnologyNotFoundException {
        Optional<Technology> technologyOptional = technologyRepository.findById(id);
        if(technologyOptional.isEmpty()){
            log.error("La tecnologia no existe");
            throw new TechnologyNotFoundException(TECHNOLOGY_NOT_FOUND);
        }
        var technology = technologyOptional.get();
        technology.setNameTechnology(technologyDtoCreateUpdate.getNameTechnology());
        var technologyDto = TechnologyMapper.mapModelToDto(technologyRepository.save(technology));
        log.info("Se modifico la tecnologia con exito");
        return technologyDto;
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
        Optional<Technology> technologyOptional = technologyRepository.findById(id);
        if(technologyOptional.isEmpty()){
            log.error("La tecnologia no existe");
            throw new TechnologyNotFoundException(TECHNOLOGY_NOT_FOUND);
        }
        technologyRepository.delete(technologyOptional.get());
        log.info("Se elimino la tecnologia con exito");
    }
}
