package com.testback.services.impl;

import com.testback.exception.CandidateNotFoundException;
import com.testback.mapper.CandidateMapper;
import com.testback.models.entities.Candidate;
import com.testback.models.views.CandidateDto;
import com.testback.models.views.CandidateDtoCreateUpdate;
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
    public CandidateDto createCandidate(CandidateDtoCreateUpdate candidateDtoCreateUpdate) {
        var candidate = CandidateMapper.mapCreateUpdateToModel(candidateDtoCreateUpdate);
        candidateRepository.save(candidate);
        return CandidateMapper.mapModelToDto(candidate);
    }

    @Override
    @Transactional
    public CandidateDto updateCandidate(Long id, CandidateDtoCreateUpdate candidateDtoCreateUpdate) throws CandidateNotFoundException {
        Optional<Candidate> candidateOptional = Optional.ofNullable(candidateRepository.findById(id)
                .orElseThrow(() -> new CandidateNotFoundException("No se encontro el Id")));
        if (candidateOptional.isEmpty()) {
            throw new CandidateNotFoundException("No se encontro el Id");
        }
        var candidate = candidateOptional.get();
        candidate.setName(candidateDtoCreateUpdate.getName());
        candidate.setLastName(candidateDtoCreateUpdate.getLastName());
        candidate.setDniType(candidateDtoCreateUpdate.getDniType());
        candidate.setDni(candidateDtoCreateUpdate.getDni());
        candidate.setBirthDate(candidateDtoCreateUpdate.getBirthDate());
        return CandidateMapper.mapModelToDto(candidateRepository.save(candidate));
    }

    @Override
    @Transactional
    public List<CandidateDto> findAll() {
        List<Candidate> candidates = candidateRepository.findAll();
        return candidates.stream().map(CandidateMapper::mapModelToDto)
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
