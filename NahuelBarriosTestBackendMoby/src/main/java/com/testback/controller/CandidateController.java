package com.testback.controller;

import com.testback.models.views.CandidateDto;
import com.testback.models.views.CandidateDtoCreate;
import com.testback.models.views.CandidateDtoUpdate;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface CandidateController {

    @PostMapping("/candidate")
    @ResponseStatus(HttpStatus.CREATED)
    CandidateDto createCandidate(@Valid @RequestBody CandidateDtoCreate candidateDtoCreate);

    @PutMapping("/candidate/{id}")
    @ResponseStatus(HttpStatus.OK)
    CandidateDto updateCandidate(@Valid @RequestBody CandidateDtoUpdate candidateDtoUpdate, @PathVariable Long id);

    @GetMapping("/candidate")
    @ResponseStatus(HttpStatus.OK)
    List<CandidateDto> findAll();

}
