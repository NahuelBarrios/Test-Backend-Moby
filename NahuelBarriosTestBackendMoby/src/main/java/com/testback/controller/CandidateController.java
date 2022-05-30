package com.testback.controller;

import com.testback.models.views.CandidateDto;
import com.testback.models.views.CandidateDtoCreate;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface CandidateController {

    @PostMapping("/candidate")
    @ResponseStatus(HttpStatus.CREATED)
    CandidateDto createCandidate(@Valid @RequestBody CandidateDtoCreate candidateDtoCreate);

}