package com.testback.controller;

import com.testback.exception.CandidateNotFoundException;
import com.testback.models.views.CandidateDto;
import com.testback.models.views.CandidateDtoCreateUpdate;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface CandidateController {

    @PostMapping("/candidate")
    @ResponseStatus(HttpStatus.CREATED)
    CandidateDto createCandidate(@Valid @RequestBody CandidateDtoCreateUpdate candidateDtoCreateUpdate);

    @PutMapping("/candidate/{id}")
    @ResponseStatus(HttpStatus.OK)
    CandidateDto updateCandidate(@Valid @RequestBody CandidateDtoCreateUpdate candidateDtoCreateUpdate, @PathVariable Long id) throws CandidateNotFoundException;

    @GetMapping("/candidate")
    @ResponseStatus(HttpStatus.OK)
    List<CandidateDto> findAll();

    @DeleteMapping("/candidate/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deleteCandidate(@PathVariable Long id) throws CandidateNotFoundException;
}
