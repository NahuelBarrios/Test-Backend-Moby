package com.testback.controller.impl;

import com.testback.controller.CandidateByTechnologyController;
import com.testback.mapper.CandidateByTechnologyMapper;
import com.testback.models.views.CandidateByTechnologyCreateUpdateDto;
import com.testback.models.views.CandidateByTechnologyDto;
import com.testback.services.impl.CandidateByTechnologyServiceImp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CandidateByTechnologyResource implements CandidateByTechnologyController {

    @Autowired
    CandidateByTechnologyServiceImp candidateByTechnologyServiceImp;

    @Override
    public ResponseEntity<CandidateByTechnologyDto> createCandidateByTechnology(CandidateByTechnologyCreateUpdateDto candidateByTechnologyCreateUpdateDto) {
        CandidateByTechnologyDto candidateByTechnologyDto = CandidateByTechnologyMapper.mapDomainToDto(
                candidateByTechnologyServiceImp.createCandidateByTechnology(candidateByTechnologyCreateUpdateDto));
        return new ResponseEntity<>(candidateByTechnologyDto, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<CandidateByTechnologyDto> updateCandidateByTechnology(CandidateByTechnologyCreateUpdateDto candidateByTechnologyCreateUpdateDto, Long id) {
        CandidateByTechnologyDto candidateByTechnologyDto = CandidateByTechnologyMapper.mapDomainToDto(
                candidateByTechnologyServiceImp.updateCandidateByTechnology(candidateByTechnologyCreateUpdateDto, id));
        return new ResponseEntity<>(candidateByTechnologyDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<CandidateByTechnologyDto>> findAll() {
        var candidatesByTechnology = candidateByTechnologyServiceImp.findAll().stream().map(CandidateByTechnologyMapper::mapDomainToDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(candidatesByTechnology, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HttpStatus> deleteCandidateByTechnology(Long id) {
        candidateByTechnologyServiceImp.deleteCandidateByTechnology(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
