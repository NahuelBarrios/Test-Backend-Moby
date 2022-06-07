package com.testback.controller.impl;

import com.testback.controller.CandidateController;
import com.testback.domain.CandidateDomain;
import com.testback.mapper.CandidateMapper;
import com.testback.models.views.CandidateDto;
import com.testback.models.views.CandidateDtoCreateUpdate;
import com.testback.services.impl.CandidateServiceImp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CandidateResource implements CandidateController {
    @Autowired
    CandidateServiceImp candidateServiceImp;

    @Override
    public ResponseEntity<CandidateDto> createCandidate(CandidateDtoCreateUpdate candidateDtoCreateUpdate) {
        CandidateDomain candidateDomain = CandidateMapper.mapCreateUpdateToDomain(candidateDtoCreateUpdate);
        CandidateDto candidateDto = CandidateMapper.mapDomainToDto(candidateServiceImp.createCandidate(candidateDomain));
        return new ResponseEntity<>(candidateDto, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<CandidateDto> updateCandidate(CandidateDtoCreateUpdate candidateDtoCreateUpdate, Long id) {
        CandidateDomain candidateDomain = CandidateMapper.mapCreateUpdateToDomain(candidateDtoCreateUpdate);
        CandidateDto candidateDto = CandidateMapper.mapDomainToDto(candidateServiceImp.updateCandidate(id, candidateDomain));
        return new ResponseEntity<>(candidateDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<CandidateDto>> findAll() {
        var candidates = candidateServiceImp.findAll().stream()
                .map(CandidateMapper::mapDomainToDto).collect(Collectors.toList());
        return new ResponseEntity<>(candidates, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HttpStatus> deleteCandidate(Long id) {
        candidateServiceImp.deleteCandidate(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
