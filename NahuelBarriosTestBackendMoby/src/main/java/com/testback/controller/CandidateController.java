package com.testback.controller;

import com.testback.exception.CandidateNotFoundException;
import com.testback.models.views.CandidateDto;
import com.testback.models.views.CandidateDtoCreateUpdate;

import java.util.List;
import javax.validation.Valid;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Candidates", description = "Operations related to Candidates")
@RequestMapping("/candidate")
public interface CandidateController {

    @Operation(
            summary = "Create new Candidate",
            description = "To create a candidate")
    @PostMapping("/add")
    ResponseEntity<CandidateDto> createCandidate(@Valid @RequestBody CandidateDtoCreateUpdate candidateDtoCreateUpdate);

    @Operation(
            summary = "Update a Candidate by id ",
            description = "To update a candidate by id")
    @PutMapping("/{id}")
    ResponseEntity<CandidateDto> updateCandidate(@Valid @RequestBody CandidateDtoCreateUpdate candidateDtoCreateUpdate, @PathVariable Long id) throws CandidateNotFoundException;

    @Operation(
            summary = "Get all  Candidates",
            description = "To get a list of candidates")
    @GetMapping()
    ResponseEntity<List<CandidateDto>> findAll();

    @Operation(
            summary = "Delete a Candidate by id",
            description = "To delete a candidate by id")
    @DeleteMapping("/{id}")
    ResponseEntity<HttpStatus> deleteCandidate(@PathVariable Long id) throws CandidateNotFoundException;
}
