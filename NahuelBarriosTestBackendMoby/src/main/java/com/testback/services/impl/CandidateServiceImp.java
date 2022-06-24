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
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
public class CandidateServiceImp implements CandidateService {

    @Autowired
    CandidateRepository candidateRepository;

    private static final String CANDIDATE_NOT_FOUND = "No se encontro el Id";

    @Override
    @Transactional
    public CandidateDto createCandidate(CandidateDtoCreateUpdate candidateDtoCreateUpdate) {
        var candidate = CandidateMapper.mapCreateUpdateToModel(candidateDtoCreateUpdate);
        candidateRepository.save(candidate);
        log.info("Se creo el candidato con exito");
        return CandidateMapper.mapModelToDto(candidate);
    }

    @Override
    @Transactional
    public CandidateDto updateCandidate(Long id, CandidateDtoCreateUpdate candidateDtoCreateUpdate) throws CandidateNotFoundException {
        Optional<Candidate> candidateOptional = candidateRepository.findById(id);
        if (candidateOptional.isEmpty()) {
            log.error("El candidato no existe");
            throw new CandidateNotFoundException(CANDIDATE_NOT_FOUND);
        }
        var candidate = candidateOptional.get();
        candidate.setName(candidateDtoCreateUpdate.getName());
        candidate.setLastName(candidateDtoCreateUpdate.getLastName());
        candidate.setDniType(candidateDtoCreateUpdate.getDniType());
        candidate.setDni(candidateDtoCreateUpdate.getDni());
        candidate.setBirthDate(candidateDtoCreateUpdate.getBirthDate());
        var candidateDto = CandidateMapper.mapModelToDto(candidateRepository.save(candidate));
        log.info("Se modifico el candidato con exito");
        return candidateDto;
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
        Optional<Candidate> candidateOptional = candidateRepository.findById(id);
        if (candidateOptional.isEmpty()) {
            log.error("El candidato no existe");
            throw new CandidateNotFoundException(CANDIDATE_NOT_FOUND);
        }
        candidateRepository.delete(candidateOptional.get());
        log.info("Se elimino el candidato con exito");
    }
}
