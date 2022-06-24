package com.testback.services.impl;

import com.testback.exception.CandidateByTechnologyNotFoundException;
import com.testback.exception.CandidateNotFoundException;
import com.testback.exception.TechnologyNotFoundException;
import com.testback.mapper.CandidateByTechnologyMapper;
import com.testback.models.entities.Candidate;
import com.testback.models.entities.CandidateByTechnology;
import com.testback.models.entities.Technology;
import com.testback.models.views.CandidateByTechnologyCreateUpdateDto;
import com.testback.models.views.CandidateByTechnologyDto;
import com.testback.projections.CandidateByTechnologyProjection;
import com.testback.repository.CandidateByTechnologyRepository;
import com.testback.repository.CandidateRepository;
import com.testback.repository.TechnologyRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.testback.services.CandidateByTechnologyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
public class CandidateByTechnologyServiceImp implements CandidateByTechnologyService {
    @Autowired
    CandidateByTechnologyRepository candidateByTechnologyRepository;
    @Autowired
    CandidateRepository candidateRepository;
    @Autowired
    TechnologyRepository technologyRepository;


    @Override
    @Transactional
    public CandidateByTechnologyDto createCandidateByTechnology(CandidateByTechnologyCreateUpdateDto candidateByTechnologyCreateUpdateDto)
            throws CandidateNotFoundException, TechnologyNotFoundException, CandidateByTechnologyNotFoundException {
        var optionalCandidate = getCandidateById(candidateByTechnologyCreateUpdateDto);
        var optionalTechnology = getTechnologyById(candidateByTechnologyCreateUpdateDto);
        var candidateByTechnology = CandidateByTechnologyMapper.mapCreatingToModel(candidateByTechnologyCreateUpdateDto, optionalTechnology, optionalCandidate);
        candidateByTechnologyRepository.save(candidateByTechnology);
        log.info("Se creo el CandidateByTechnology con exito");
        return CandidateByTechnologyMapper.mapModelToDto(candidateByTechnology);
    }

    @Override
    @Transactional
    public CandidateByTechnologyDto updateCandidateByTechnology(CandidateByTechnologyCreateUpdateDto candidateByTechnologyCreateUpdateDto,
                                                                Long id) throws CandidateNotFoundException, TechnologyNotFoundException,
            CandidateByTechnologyNotFoundException {
        var candidateByTechnology = getCandidateByTechnology(id);
        var candidate = getCandidateById(candidateByTechnologyCreateUpdateDto);
        var technology = getTechnologyById(candidateByTechnologyCreateUpdateDto);
        candidateByTechnology.setCandidate(candidate);
        candidateByTechnology.setTechnology(technology);
        candidateByTechnology.setExperience(candidateByTechnologyCreateUpdateDto.getExperience());
        var candidateByTechnologyDto = CandidateByTechnologyMapper.mapModelToDto(candidateByTechnologyRepository.save(candidateByTechnology));
        log.info("Se modifico el CandidateByTechnology con exito");
        return candidateByTechnologyDto;
    }

    @Override
    @Transactional
    public List<CandidateByTechnologyDto> findAll() {
        List<CandidateByTechnology> candidateByTechnologies = candidateByTechnologyRepository.findAll();
        return candidateByTechnologies.stream().map(CandidateByTechnologyMapper::mapModelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CandidateByTechnologyProjection> findCandidatesByTechnologies(String nameTechnology) {
        return candidateByTechnologyRepository.getCandidatesByTechnologies(nameTechnology);
    }

    @Override
    @Transactional
    public void deleteCandidateByTechnology(Long id) throws CandidateByTechnologyNotFoundException {
        Optional<CandidateByTechnology> candidateByTechnologyOptional = candidateByTechnologyRepository.findById(id);
        if (candidateByTechnologyOptional.isEmpty()) {
            log.error("La tecnologia no existe");
            throw new CandidateByTechnologyNotFoundException("No se encontro el Id del candidato x tecnologia");
        }
        candidateByTechnologyRepository.delete(candidateByTechnologyOptional.get());
        log.info("Se elimino la tecnologia con exito");
    }

    private Candidate getCandidateById(CandidateByTechnologyCreateUpdateDto candidateByTechnologyCreateUpdateDto) throws CandidateNotFoundException {
        return candidateRepository.findById(candidateByTechnologyCreateUpdateDto.getCandidateId())
                .orElseThrow(() -> {
                    log.error("el candidato no existe");
                    throw new CandidateNotFoundException("No se encontro el Id del candidato");
                });
    }

    private Technology getTechnologyById(CandidateByTechnologyCreateUpdateDto candidateByTechnologyCreateUpdateDto) throws TechnologyNotFoundException {
        return technologyRepository.findById(candidateByTechnologyCreateUpdateDto.getTechnologyId())
                .orElseThrow(() -> {
                    log.error("la tecnologia no existe");
                    throw new TechnologyNotFoundException("No se encontro el Id de la tecnologia");
                });
    }

    private CandidateByTechnology getCandidateByTechnology(Long id) throws CandidateByTechnologyNotFoundException {
        return candidateByTechnologyRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("el candidato x tecnologia no existe");
                    throw new CandidateByTechnologyNotFoundException("No se encontro el Id del candidato x tecnologia");
                });
    }

}
