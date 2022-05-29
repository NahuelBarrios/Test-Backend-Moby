package com.testback.services;

import com.testback.domain.CandidateDomain;
import com.testback.mapper.CandidateMapper;
import com.testback.models.entities.Candidate;
import com.testback.repository.CandidateRepository;

public class CandidateService {

    private final CandidateRepository candidateRepository;

    public CandidateService(CandidateRepository candidateRepository){
        this.candidateRepository = candidateRepository;
    }

    public CandidateDomain createCandidate(CandidateDomain candidateDomain){
        Candidate candidate = CandidateMapper.mapDomainToModel(candidateDomain);
        candidateRepository.save(candidate);
        return CandidateMapper.mapModelToDomain(candidate);
    }

}
