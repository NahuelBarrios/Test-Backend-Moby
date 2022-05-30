package com.testback.controller.impl;

import com.testback.controller.CandidateController;
import com.testback.domain.CandidateDomain;
import com.testback.mapper.CandidateMapper;
import com.testback.models.views.CandidateDto;
import com.testback.models.views.CandidateDtoCreate;
import com.testback.models.views.CandidateDtoUpdate;
import com.testback.services.CandidateService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CandidateResource implements CandidateController {

    private final CandidateService candidateService;

    public CandidateResource(CandidateService candidateService){
        this.candidateService = candidateService;
    }

    @Override
    public CandidateDto createCandidate(CandidateDtoCreate candidateDtoCreate) {
        CandidateDomain candidateDomain = CandidateMapper.mapCreateToDomain(candidateDtoCreate);
        return CandidateMapper.mapDomainToDto(candidateService.createCandidate(candidateDomain));
    }

    @Override
    public CandidateDto updateCandidate(CandidateDtoUpdate candidateDtoUpdate, Long id) {
        CandidateDomain candidateDomain = CandidateMapper.mapUpdateToDomain(candidateDtoUpdate);
        return CandidateMapper.mapDomainToDto(candidateService.updateCandidate(id,candidateDomain));
    }

    @Override
    public List<CandidateDto> findAll() {
        return candidateService.findAll().stream()
                .map(CandidateMapper::mapDomainToDto).collect(Collectors.toList());
    }

    @Override
    public void deleteCandidate(Long id) {
        candidateService.deleteCandidate(id);
    }
}
