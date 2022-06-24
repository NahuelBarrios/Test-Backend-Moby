package com.testback.controller.impl;

import com.testback.controller.CandidateByTechnologyController;
import com.testback.models.views.CandidateByTechnologyCreateUpdateDto;
import com.testback.models.views.CandidateByTechnologyDto;
import com.testback.projections.CandidateByTechnologyProjection;
import com.testback.services.impl.CandidateByTechnologyServiceImp;

import java.util.List;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "CandidateByTechnologyResource", tags = {"CandidatesByTechnologies"})
@RestController
public class CandidateByTechnologyResource implements CandidateByTechnologyController {

    @Autowired
    CandidateByTechnologyServiceImp candidateByTechnologyServiceImp;

    @Override
    public ResponseEntity<CandidateByTechnologyDto> createCandidateByTechnology
            (CandidateByTechnologyCreateUpdateDto candidateByTechnologyCreateUpdateDto) {
        return new ResponseEntity<>(candidateByTechnologyServiceImp
                .createCandidateByTechnology(candidateByTechnologyCreateUpdateDto), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<CandidateByTechnologyDto> updateCandidateByTechnology
            (CandidateByTechnologyCreateUpdateDto candidateByTechnologyCreateUpdateDto, Long id) {
        return new ResponseEntity<>(candidateByTechnologyServiceImp
                .updateCandidateByTechnology(candidateByTechnologyCreateUpdateDto, id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<CandidateByTechnologyDto>> findAll() {
        return new ResponseEntity<>(candidateByTechnologyServiceImp.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HttpStatus> deleteCandidateByTechnology(Long id) {
        candidateByTechnologyServiceImp.deleteCandidateByTechnology(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<CandidateByTechnologyProjection>> findCandidatesByTechnologies(String name) {
        return new ResponseEntity<>(candidateByTechnologyServiceImp.findCandidatesByTechnologies(name),HttpStatus.OK);
    }
}
