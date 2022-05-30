package com.testback.services;

import com.testback.domain.CandidateDomain;
import com.testback.exception.CandidateNotFoundException;
import com.testback.mapper.CandidateMapper;
import com.testback.models.entities.Candidate;
import com.testback.repository.CandidateRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
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
        Optional<Candidate> candidateOptional = Optional.ofNullable(candidateRepository.findById(id)
                .orElseThrow(() -> new CandidateNotFoundException("No se encontro el Id")));
        Candidate candidate = candidateOptional.get();
        candidate.setName(candidateDomain.getName());
        candidate.setLastName(candidateDomain.getLastName());
        candidate.setDniType(candidateDomain.getDniType());
        candidate.setDni(candidateDomain.getDni());
        candidate.setBirthDate(candidateDomain.getBirthDate());
        return CandidateMapper.mapModelToDomain(candidateRepository.save(candidate));
    }

    @Transactional
    public List<CandidateDomain> findAll(){
        List<Candidate> candidates = candidateRepository.findAll();
        return candidates.stream().map(CandidateMapper::mapModelToDomain)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteCandidate(Long id) throws CandidateNotFoundException{
        Optional<Candidate> candidateOptional = Optional.ofNullable(candidateRepository.findById(id)
                .orElseThrow(() -> new CandidateNotFoundException("No se encontro el Id")));
        candidateRepository.delete(candidateOptional.get());
    }


}
