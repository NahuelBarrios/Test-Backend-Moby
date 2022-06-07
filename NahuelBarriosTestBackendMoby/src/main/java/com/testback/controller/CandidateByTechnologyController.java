package com.testback.controller;

import com.testback.exception.CandidateByTechnologyNotFoundException;
import com.testback.exception.CandidateNotFoundException;
import com.testback.exception.TechnologyNotFoundException;
import com.testback.models.views.CandidateByTechnologyCreateUpdateDto;
import com.testback.models.views.CandidateByTechnologyDto;

import java.util.List;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/candidatebytechnology")
public interface CandidateByTechnologyController {

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    CandidateByTechnologyDto createCandidateByTechnology(@Valid @RequestBody CandidateByTechnologyCreateUpdateDto candidateByTechnologyCreateUpdateDto);

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    CandidateByTechnologyDto updateCandidateByTechnology(@Valid @RequestBody CandidateByTechnologyCreateUpdateDto candidateByTechnologyCreateUpdateDto,
                                                         @PathVariable Long id) throws CandidateNotFoundException, TechnologyNotFoundException,
            CandidateByTechnologyNotFoundException;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    List<CandidateByTechnologyDto> findAll();

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deleteCandidateByTechnology(@PathVariable Long id) throws CandidateByTechnologyNotFoundException;

}
