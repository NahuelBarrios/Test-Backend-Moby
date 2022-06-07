package com.testback.services.impl;

import com.testback.domain.CandidateByTechnologyDomain;
import com.testback.exception.CandidateByTechnologyNotFoundException;
import com.testback.exception.CandidateNotFoundException;
import com.testback.exception.TechnologyNotFoundException;
import com.testback.mapper.CandidateByTechnologyMapper;
import com.testback.models.entities.Candidate;
import com.testback.models.entities.CandidateByTechnology;
import com.testback.models.entities.Technology;
import com.testback.models.views.CandidateByTechnologyCreateUpdateDto;
import com.testback.repository.CandidateByTechnologyRepository;
import com.testback.repository.CandidateRepository;
import com.testback.repository.TechnologyRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.testback.services.CandidateByTechnologyService;
import org.springframework.transaction.annotation.Transactional;

public class CandidateByTechnologyServiceImp implements CandidateByTechnologyService {

    private final CandidateByTechnologyRepository candidateByTechnologyRepository;
    private final CandidateRepository candidateRepository;
    private final TechnologyRepository technologyRepository;

    public CandidateByTechnologyServiceImp(CandidateByTechnologyRepository candidateByTechnologyRepository,
                                           CandidateRepository candidateRepository, TechnologyRepository technologyRepository) {
        this.candidateByTechnologyRepository = candidateByTechnologyRepository;
        this.candidateRepository = candidateRepository;
        this.technologyRepository = technologyRepository;
    }

    @Override
    public CandidateByTechnologyDomain createCandidateByTechnology(CandidateByTechnologyCreateUpdateDto candidateByTechnologyCreateUpdateDto)
            throws CandidateNotFoundException, TechnologyNotFoundException, CandidateByTechnologyNotFoundException {
        Optional<Candidate> optionalCandidate = getOptionalCandidate(candidateByTechnologyCreateUpdateDto);
        Optional<Technology> optionalTechnology = getOptionalTechnology(candidateByTechnologyCreateUpdateDto);
        CandidateByTechnology candidateByTechnology = CandidateByTechnologyMapper.mapCreatingToModel(candidateByTechnologyCreateUpdateDto, optionalTechnology.get(), optionalCandidate.get());
        return CandidateByTechnologyMapper.mapModelToDomain(candidateByTechnologyRepository.save(candidateByTechnology));
    }

    @Override
    public CandidateByTechnologyDomain updateCandidateByTechnology(CandidateByTechnologyCreateUpdateDto candidateByTechnologyCreateUpdateDto,
                                                                   Long id) throws CandidateNotFoundException, TechnologyNotFoundException,
            CandidateByTechnologyNotFoundException {
        Optional<CandidateByTechnology> optionalCandidateByTechnology = getOptionalCandidateByTechnology(id);
        Optional<Candidate> optionalCandidate = getOptionalCandidate(candidateByTechnologyCreateUpdateDto);
        Optional<Technology> optionalTechnology = getOptionalTechnology(candidateByTechnologyCreateUpdateDto);
        CandidateByTechnology candidateByTechnology = optionalCandidateByTechnology.get();
        candidateByTechnology.setCandidate(optionalCandidate.get());
        candidateByTechnology.setTechnology(optionalTechnology.get());
        candidateByTechnology.setExperience(candidateByTechnologyCreateUpdateDto.getExperience());
        return CandidateByTechnologyMapper.mapModelToDomain(candidateByTechnologyRepository.save(candidateByTechnology));
    }

    @Override
    public List<CandidateByTechnologyDomain> findAll() {
        List<CandidateByTechnology> candidateByTechnologies = candidateByTechnologyRepository.findAll();
        return candidateByTechnologies.stream().map(CandidateByTechnologyMapper::mapModelToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCandidateByTechnology(Long id) throws CandidateByTechnologyNotFoundException {
        Optional<CandidateByTechnology> candidateByTechnologyOptional = getOptionalCandidateByTechnology(id);
        candidateByTechnologyRepository.delete(candidateByTechnologyOptional.get());
    }

    private Optional<Candidate> getOptionalCandidate(CandidateByTechnologyCreateUpdateDto candidateByTechnologyCreateUpdateDto) throws CandidateNotFoundException {
        return Optional.ofNullable(candidateRepository.findById(candidateByTechnologyCreateUpdateDto.getCandidateId())
                .orElseThrow(() -> new CandidateNotFoundException("No se encontro el Id del candidato")));
    }

    private Optional<Technology> getOptionalTechnology(CandidateByTechnologyCreateUpdateDto candidateByTechnologyCreateUpdateDto) throws TechnologyNotFoundException {
        return Optional.ofNullable(technologyRepository.findById(candidateByTechnologyCreateUpdateDto.getTechnologyId())
                .orElseThrow(() -> new TechnologyNotFoundException("No se encontro el Id de la tecnologia")));
    }

    private Optional<CandidateByTechnology> getOptionalCandidateByTechnology(Long id) throws CandidateByTechnologyNotFoundException {
        return Optional.ofNullable(candidateByTechnologyRepository.findById(id)
                .orElseThrow(() -> new CandidateNotFoundException("No se encontro el Id del candidato x tecnologia")));
    }

}
