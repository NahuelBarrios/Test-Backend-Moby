package com.testback.services;

import com.testback.domain.CandidateDomain;
import com.testback.exception.CandidateNotFoundException;
import com.testback.mapper.CandidateMapper;
import com.testback.models.entities.Candidate;
import com.testback.repository.CandidateRepository;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;

public class CandidateService {

    private final CandidateRepository candidateRepository;

    public CandidateService(CandidateRepository candidateRepository){
        this.candidateRepository = candidateRepository;
    }

    @Transactional
    public CandidateDomain createCandidate(CandidateDomain candidateDomain){
        Candidate candidate = CandidateMapper.mapDomainToModel(candidateDomain);
        candidateRepository.save(candidate);
        return CandidateMapper.mapModelToDomain(candidate);
    }

    @Transactional
    public CandidateDomain updateCandidate(Long id,CandidateDomain candidateDomain) throws CandidateNotFoundException{
        Optional<Candidate> candidateOptional = candidateRepository.findById(id);
        if(candidateOptional.isEmpty()){
            throw new CandidateNotFoundException("Id no encontrado");
        }
        Candidate candidate = candidateOptional.get();
        candidate.setName(candidateDomain.getName());
        candidate.setLastName(candidateDomain.getLastName());
        candidate.setDniType(candidateDomain.getDniType());
        candidate.setDni(candidateDomain.getDni());
        candidate.setBirthDate(candidateDomain.getBirthDate());
        return CandidateMapper.mapModelToDomain(candidateRepository.save(candidate));

    }

}
