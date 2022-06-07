package com.testback.controller.impl;

import com.testback.controller.CandidateController;
import com.testback.domain.CandidateDomain;
import com.testback.mapper.CandidateMapper;
import com.testback.models.views.CandidateDto;
import com.testback.models.views.CandidateDtoCreateUpdate;
import com.testback.services.impl.CandidateServiceImp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class CandidateResource implements CandidateController {

    private final CandidateServiceImp candidateServiceImp;

    public CandidateResource(CandidateServiceImp candidateServiceImp) {
        this.candidateServiceImp = candidateServiceImp;
    }

    @Override
    public CandidateDto createCandidate(CandidateDtoCreateUpdate candidateDtoCreateUpdate) {
        CandidateDomain candidateDomain = CandidateMapper.mapCreateUpdateToDomain(candidateDtoCreateUpdate);
        return CandidateMapper.mapDomainToDto(candidateServiceImp.createCandidate(candidateDomain));
    }

    @Override
    public CandidateDto updateCandidate(CandidateDtoCreateUpdate candidateDtoCreateUpdate, Long id) {
        CandidateDomain candidateDomain = CandidateMapper.mapCreateUpdateToDomain(candidateDtoCreateUpdate);
        return CandidateMapper.mapDomainToDto(candidateServiceImp.updateCandidate(id, candidateDomain));
    }

    @Override
    public List<CandidateDto> findAll() {
        return candidateServiceImp.findAll().stream()
                .map(CandidateMapper::mapDomainToDto).collect(Collectors.toList());
    }

    @Override
    public void deleteCandidate(Long id) {
        candidateServiceImp.deleteCandidate(id);
    }
}
