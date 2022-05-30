package com.testback.controller;

import com.testback.models.views.CandidateByTechnologyCreateDto;
import com.testback.models.views.CandidateByTechnologyDto;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface CandidateByTechnologyController {

    @PostMapping("/candidatebytechnology")
    @ResponseStatus(HttpStatus.CREATED)
    CandidateByTechnologyDto createCandidateByTechnology(@Valid @RequestBody CandidateByTechnologyCreateDto candidateByTechnologyCreateDto);
}
