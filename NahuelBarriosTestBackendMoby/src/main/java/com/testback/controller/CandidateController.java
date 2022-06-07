package com.testback.controller;

import com.testback.exception.CandidateNotFoundException;
import com.testback.models.views.CandidateDto;
import com.testback.models.views.CandidateDtoCreateUpdate;

import java.util.List;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/candidate")
public interface CandidateController {

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    CandidateDto createCandidate(@Valid @RequestBody CandidateDtoCreateUpdate candidateDtoCreateUpdate);

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    CandidateDto updateCandidate(@Valid @RequestBody CandidateDtoCreateUpdate candidateDtoCreateUpdate, @PathVariable Long id) throws CandidateNotFoundException;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    List<CandidateDto> findAll();

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deleteCandidate(@PathVariable Long id) throws CandidateNotFoundException;
}
