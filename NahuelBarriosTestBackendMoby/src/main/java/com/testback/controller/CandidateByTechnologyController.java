package com.testback.controller;

import com.testback.exception.CandidateByTechnologyNotFoundException;
import com.testback.exception.CandidateNotFoundException;
import com.testback.exception.TechnologyNotFoundException;
import com.testback.models.views.CandidateByTechnologyCreateUpdateDto;
import com.testback.models.views.CandidateByTechnologyDto;

import java.util.List;
import javax.validation.Valid;

import com.testback.projections.CandidateByTechnologyProjection;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "CandidatesByTechnologies", description = "Operations related to CandidatesByTechnologies")
@RequestMapping("/candidatebytechnology")
public interface CandidateByTechnologyController {

    @Operation(
            summary = "Create new CandidateByTechnology",
            description = "To create a candidate by technology")
    @PostMapping("/add")
    ResponseEntity<CandidateByTechnologyDto> createCandidateByTechnology(@Valid @RequestBody CandidateByTechnologyCreateUpdateDto candidateByTechnologyCreateUpdateDto);

    @Operation(
            summary = "Update a CandidateByTechnology by id ",
            description = "To update a candidate by technology by id")
    @PutMapping("/{id}")
    ResponseEntity<CandidateByTechnologyDto> updateCandidateByTechnology(@Valid @RequestBody CandidateByTechnologyCreateUpdateDto candidateByTechnologyCreateUpdateDto,
                                                                         @PathVariable Long id) throws CandidateNotFoundException, TechnologyNotFoundException,
            CandidateByTechnologyNotFoundException;

    @Operation(
            summary = "Get all  CandidatesByTechnologies",
            description = "To get a list of candidate by technology")
    @GetMapping()
    ResponseEntity<List<CandidateByTechnologyDto>> findAll();

    @Operation(
            summary = "Delete a CandidateByTechnology by id",
            description = "To delete a candidate by technology by id")
    @DeleteMapping("/{id}")
    ResponseEntity<HttpStatus> deleteCandidateByTechnology(@PathVariable Long id) throws CandidateByTechnologyNotFoundException;

    @Operation(
            summary = "Get all CandidatesByTechnologies by name",
            description = "To get a list of candidate by technology by name")
    @GetMapping("/search/{name}")
    ResponseEntity<List<CandidateByTechnologyProjection>> findCandidatesByTechnologies(@PathVariable String name);

}
