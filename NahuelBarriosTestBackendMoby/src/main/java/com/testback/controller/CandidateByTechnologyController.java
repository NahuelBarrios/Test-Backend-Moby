package com.testback.controller;

import com.testback.exception.CandidateByTechnologyNotFoundException;
import com.testback.exception.CandidateNotFoundException;
import com.testback.exception.TechnologyNotFoundException;
import com.testback.models.views.CandidateByTechnologyCreateUpdateDto;
import com.testback.models.views.CandidateByTechnologyDto;
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

public interface CandidateByTechnologyController {

    @PostMapping("/candidatebytechnology")
    @ResponseStatus(HttpStatus.CREATED)
    CandidateByTechnologyDto createCandidateByTechnology(@Valid @RequestBody CandidateByTechnologyCreateUpdateDto candidateByTechnologyCreateUpdateDto);

    @PutMapping("/candidatebytechnology/{id}")
    @ResponseStatus(HttpStatus.OK)
    CandidateByTechnologyDto updateCandidateByTechnology(@Valid @RequestBody CandidateByTechnologyCreateUpdateDto candidateByTechnologyCreateUpdateDto,
                                                         @PathVariable Long id) throws CandidateNotFoundException, TechnologyNotFoundException,
                                                                                        CandidateByTechnologyNotFoundException;

    @GetMapping("/candidatebytechnology")
    @ResponseStatus(HttpStatus.OK)
    List<CandidateByTechnologyDto> findAll();

    @DeleteMapping("/candidatebytechnology/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deleteCandidateByTechnology(@PathVariable Long id) throws CandidateByTechnologyNotFoundException;

}
