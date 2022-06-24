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
        Optional<Candidate> optionalCandidate = getOptionalCandidate(candidateByTechnologyCreateUpdateDto);
        Optional<Technology> optionalTechnology = getOptionalTechnology(candidateByTechnologyCreateUpdateDto);
        if (optionalCandidate.isEmpty() || optionalTechnology.isEmpty()) {
            log.error("No se pudo crear el candidato");
            throw new CandidateByTechnologyNotFoundException("No se pudo crear la entidad Candidato por Tecnologia");
        }
        var candidateByTechnology = CandidateByTechnologyMapper.mapCreatingToModel(candidateByTechnologyCreateUpdateDto, optionalTechnology.get(), optionalCandidate.get());
        candidateByTechnologyRepository.save(candidateByTechnology);
        log.info("Se creo el CandidateByTechnology con exito");
        return CandidateByTechnologyMapper.mapModelToDto(candidateByTechnology);
    }

    @Override
    @Transactional
    public CandidateByTechnologyDto updateCandidateByTechnology(CandidateByTechnologyCreateUpdateDto candidateByTechnologyCreateUpdateDto,
                                                                Long id) throws CandidateNotFoundException, TechnologyNotFoundException,
            CandidateByTechnologyNotFoundException {
        Optional<CandidateByTechnology> optionalCandidateByTechnology = getOptionalCandidateByTechnology(id);
        Optional<Candidate> optionalCandidate = getOptionalCandidate(candidateByTechnologyCreateUpdateDto);
        Optional<Technology> optionalTechnology = getOptionalTechnology(candidateByTechnologyCreateUpdateDto);
        if (optionalCandidate.isEmpty() || optionalTechnology.isEmpty() || optionalCandidateByTechnology.isEmpty()) {
            log.error("la informacion no existe");
            throw new CandidateByTechnologyNotFoundException("No se pudo modificar el candidato por tecnologia");
        }
        var candidateByTechnology = optionalCandidateByTechnology.get();
        candidateByTechnology.setCandidate(optionalCandidate.get());
        candidateByTechnology.setTechnology(optionalTechnology.get());
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
        Optional<CandidateByTechnology> candidateByTechnologyOptional = getOptionalCandidateByTechnology(id);
        if (candidateByTechnologyOptional.isEmpty()) {
            log.error("La tecnologia no existe");
            throw new CandidateByTechnologyNotFoundException("No se encontro el Id del candidato x tecnologia");
        }
        candidateByTechnologyRepository.delete(candidateByTechnologyOptional.get());
        log.info("Se elimino la tecnologia con exito");
    }

    private Optional<Candidate> getOptionalCandidate(CandidateByTechnologyCreateUpdateDto candidateByTechnologyCreateUpdateDto) throws CandidateNotFoundException {
        return Optional.ofNullable(candidateRepository.findById(candidateByTechnologyCreateUpdateDto.getCandidateId())
                .orElseThrow(() -> {
                    log.error("el candidato no existe");
                    return new CandidateNotFoundException("No se encontro el Id del candidato");
                }));
    }

    private Optional<Technology> getOptionalTechnology(CandidateByTechnologyCreateUpdateDto candidateByTechnologyCreateUpdateDto) throws TechnologyNotFoundException {
        return Optional.ofNullable(technologyRepository.findById(candidateByTechnologyCreateUpdateDto.getTechnologyId())
                .orElseThrow(() -> {
                    log.error("la tecnologia no existe");
                    return new TechnologyNotFoundException("No se encontro el Id de la tecnologia");
                }));
    }

    private Optional<CandidateByTechnology> getOptionalCandidateByTechnology(Long id) throws CandidateByTechnologyNotFoundException {
        return Optional.ofNullable(candidateByTechnologyRepository.findById(id)
                .orElseThrow(() -> { log.error("el candidato x tecnologia no existe");
                    return new CandidateNotFoundException("No se encontro el Id del candidato x tecnologia");}
        ));
    }

}
