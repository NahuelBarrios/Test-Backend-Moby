package com.testback.controller.impl;

import com.testback.controller.CandidateController;
import com.testback.domain.CandidateDomain;
import com.testback.mapper.CandidateMapper;
import com.testback.models.views.CandidateDto;
import com.testback.models.views.CandidateDtoCreateUpdate;
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
    public CandidateDto createCandidate(CandidateDtoCreateUpdate candidateDtoCreateUpdate) {
        CandidateDomain candidateDomain = CandidateMapper.mapCreateUpdateToDomain(candidateDtoCreateUpdate);
        return CandidateMapper.mapDomainToDto(candidateService.createCandidate(candidateDomain));
    }

    @Override
    public CandidateDto updateCandidate(CandidateDtoCreateUpdate candidateDtoCreateUpdate, Long id) {
        CandidateDomain candidateDomain = CandidateMapper.mapCreateUpdateToDomain(candidateDtoCreateUpdate);
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
