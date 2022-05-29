package com.testback.controller.impl;

import com.testback.controller.CandidateController;
import com.testback.domain.CandidateDomain;
import com.testback.mapper.CandidateMapper;
import com.testback.models.views.CandidateDto;
import com.testback.models.views.CandidateDtoCreate;
import com.testback.services.CandidateService;
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
}
