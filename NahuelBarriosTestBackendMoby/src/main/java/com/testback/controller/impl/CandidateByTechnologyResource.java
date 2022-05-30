package com.testback.controller.impl;

import com.testback.controller.CandidateByTechnologyController;
import com.testback.mapper.CandidateByTechnologyMapper;
import com.testback.models.views.CandidateByTechnologyCreateUpdateDto;
import com.testback.models.views.CandidateByTechnologyDto;
import com.testback.services.CandidateByTechnologyService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CandidateByTechnologyResource implements CandidateByTechnologyController {

    private final CandidateByTechnologyService candidateByTechnologyService;

    public CandidateByTechnologyResource (CandidateByTechnologyService candidateByTechnologyService){
        this.candidateByTechnologyService = candidateByTechnologyService;
    }

    @Override
    public CandidateByTechnologyDto createCandidateByTechnology(CandidateByTechnologyCreateUpdateDto candidateByTechnologyCreateUpdateDto) {
        return CandidateByTechnologyMapper.mapDomainToDto(candidateByTechnologyService.createCandidateByTechnology(candidateByTechnologyCreateUpdateDto));
    }

    @Override
    public CandidateByTechnologyDto updateCandidateByTechnology(CandidateByTechnologyCreateUpdateDto candidateByTechnologyCreateUpdateDto,Long id) {
        return CandidateByTechnologyMapper.mapDomainToDto(candidateByTechnologyService.updateCandidateByTechnology(candidateByTechnologyCreateUpdateDto,id));
    }

    @Override
    public List<CandidateByTechnologyDto> findAll() {
        return candidateByTechnologyService.findAll().stream().map(CandidateByTechnologyMapper::mapDomainToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCandidateByTechnology(Long id) {
        candidateByTechnologyService.deleteCandidateByTechnology(id);
    }
}
