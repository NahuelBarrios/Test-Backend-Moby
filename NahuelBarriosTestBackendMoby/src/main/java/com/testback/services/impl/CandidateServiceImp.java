package com.testback.services.impl;

import com.testback.domain.CandidateDomain;
import com.testback.exception.CandidateNotFoundException;
import com.testback.mapper.CandidateMapper;
import com.testback.models.entities.Candidate;
import com.testback.repository.CandidateRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.testback.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CandidateServiceImp implements CandidateService {

    @Autowired
    CandidateRepository candidateRepository;

    @Override
    @Transactional
    public CandidateDomain createCandidate(CandidateDomain candidateDomain) {
        var candidate = CandidateMapper.mapDomainToModel(candidateDomain);
        candidateRepository.save(candidate);
        return CandidateMapper.mapModelToDomain(candidate);
    }

    @Override
    @Transactional
    public CandidateDomain updateCandidate(Long id, CandidateDomain candidateDomain) throws CandidateNotFoundException {
        Optional<Candidate> candidateOptional = Optional.ofNullable(candidateRepository.findById(id)
                .orElseThrow(() -> new CandidateNotFoundException("No se encontro el Id")));
        if (candidateOptional.isEmpty()){
            throw new CandidateNotFoundException("No se encontro el Id");
        }
        var candidate = candidateOptional.get();
        candidate.setName(candidateDomain.getName());
        candidate.setLastName(candidateDomain.getLastName());
        candidate.setDniType(candidateDomain.getDniType());
        candidate.setDni(candidateDomain.getDni());
        candidate.setBirthDate(candidateDomain.getBirthDate());
        return CandidateMapper.mapModelToDomain(candidateRepository.save(candidate));
    }

    @Override
    @Transactional
    public List<CandidateDomain> findAll() {
        List<Candidate> candidates = candidateRepository.findAll();
        return candidates.stream().map(CandidateMapper::mapModelToDomain)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteCandidate(Long id) throws CandidateNotFoundException {
        Optional<Candidate> candidateOptional = Optional.ofNullable(candidateRepository.findById(id)
                .orElseThrow(() -> new CandidateNotFoundException("No se encontro el Id")));
        candidateRepository.delete(candidateOptional.get());
    }
}
