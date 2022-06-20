package com.testback.controller.impl;

import com.testback.controller.CandidateController;
import com.testback.exception.CandidateNotFoundException;
import com.testback.models.views.CandidateDto;
import com.testback.models.views.CandidateDtoCreateUpdate;
import com.testback.services.impl.CandidateServiceImp;

import java.util.List;

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
        return new ResponseEntity<>(candidateServiceImp.createCandidate(candidateDtoCreateUpdate), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<CandidateDto> updateCandidate(CandidateDtoCreateUpdate candidateDtoCreateUpdate,
                                                        Long id) throws CandidateNotFoundException {
        return new ResponseEntity<>(candidateServiceImp.updateCandidate(id, candidateDtoCreateUpdate), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<CandidateDto>> findAll() {
        return new ResponseEntity<>(candidateServiceImp.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HttpStatus> deleteCandidate(Long id) throws CandidateNotFoundException {
        candidateServiceImp.deleteCandidate(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
