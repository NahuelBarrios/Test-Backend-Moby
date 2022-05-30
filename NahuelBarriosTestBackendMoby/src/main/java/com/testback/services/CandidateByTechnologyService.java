package com.testback.services;

import com.testback.domain.CandidateByTechnologyDomain;
import com.testback.exception.CandidateNotFoundException;
import com.testback.exception.TechnologyNotFoundException;
import com.testback.mapper.CandidateByTechnologyMapper;
import com.testback.models.entities.Candidate;
import com.testback.models.entities.CandidateByTechnology;
import com.testback.models.entities.Technology;
import com.testback.models.views.CandidateByTechnologyCreateDto;
import com.testback.repository.CandidateByTechnologyRepository;
import com.testback.repository.CandidateRepository;
import com.testback.repository.TechnologyRepository;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;

public class CandidateByTechnologyService {

    private final CandidateByTechnologyRepository candidateByTechnologyRepository;
    private final CandidateRepository candidateRepository;
    private final TechnologyRepository technologyRepository;

    public CandidateByTechnologyService(CandidateByTechnologyRepository candidateByTechnologyRepository,
                                        CandidateRepository candidateRepository, TechnologyRepository technologyRepository) {
        this.candidateByTechnologyRepository = candidateByTechnologyRepository;
        this.candidateRepository = candidateRepository;
        this.technologyRepository = technologyRepository;
    }

    @Transactional
    public CandidateByTechnologyDomain createCandidateByTechnology(CandidateByTechnologyCreateDto candidateByTechnologyCreateDto) throws CandidateNotFoundException, TechnologyNotFoundException{
        Optional<Candidate> optionalCandidate = Optional.ofNullable(candidateRepository.findById(candidateByTechnologyCreateDto.getCandidateId())
                .orElseThrow(() -> new CandidateNotFoundException("No se encontro el Id del candidato")));

        Optional<Technology> optionalTechnology = Optional.ofNullable(technologyRepository.findById(candidateByTechnologyCreateDto.getTechnologyId())
                .orElseThrow(() -> new TechnologyNotFoundException("No se encontro el Id de la tecnologia")));
        CandidateByTechnology candidateByTechnology = CandidateByTechnologyMapper.mapCreatingToModel(candidateByTechnologyCreateDto,optionalTechnology.get(),optionalCandidate.get());
        return CandidateByTechnologyMapper.mapModelToDomain(candidateByTechnologyRepository.save(candidateByTechnology));
    }
}
