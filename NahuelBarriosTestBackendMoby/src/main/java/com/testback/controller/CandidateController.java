package com.testback.controller;

import com.testback.exception.CandidateNotFoundException;
import com.testback.models.views.CandidateDto;
import com.testback.models.views.CandidateDtoCreateUpdate;

import java.util.List;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/candidate")
public interface CandidateController {

    @PostMapping("/add")
    ResponseEntity<CandidateDto> createCandidate(@Valid @RequestBody CandidateDtoCreateUpdate candidateDtoCreateUpdate);

    @PutMapping("/{id}")
    ResponseEntity<CandidateDto> updateCandidate(@Valid @RequestBody CandidateDtoCreateUpdate candidateDtoCreateUpdate, @PathVariable Long id) throws CandidateNotFoundException;

    @GetMapping()
    ResponseEntity<List<CandidateDto>> findAll();

    @DeleteMapping("/{id}")
    ResponseEntity<HttpStatus> deleteCandidate(@PathVariable Long id) throws CandidateNotFoundException;
}
