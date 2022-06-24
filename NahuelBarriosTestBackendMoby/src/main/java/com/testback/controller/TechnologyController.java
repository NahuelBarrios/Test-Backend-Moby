package com.testback.controller;

import com.testback.exception.TechnologyNotFoundException;
import com.testback.models.views.TechnologyDto;
import com.testback.models.views.TechnologyDtoCreateUpdate;

import java.util.List;
import javax.validation.Valid;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Technologies", description = "Operations related to Technologies")
@RequestMapping("/technology")
public interface TechnologyController {

    @Operation(
            summary = "Create new Technology",
            description = "To create a technology")
    @PostMapping("/add")
    ResponseEntity<TechnologyDto> createTechnology(@Valid @RequestBody TechnologyDtoCreateUpdate technologyDtoCreateUpdate);

    @Operation(
            summary = "Update a Technology by id",
            description = "To update a technology by id")
    @PutMapping("/{id}")
    ResponseEntity<TechnologyDto> updateTechnology(@Valid @RequestBody TechnologyDtoCreateUpdate technologyDtoCreateUpdate, @PathVariable Long id) throws TechnologyNotFoundException;

    @Operation(
            summary = "Get all  Technologies",
            description = "To get a list of technologies")
    @GetMapping()
    ResponseEntity<List<TechnologyDto>> findAll();

    @Operation(
            summary = "Delete a Technology by id",
            description = "To delete a technology by id")
    @DeleteMapping("/{id}")
    ResponseEntity<HttpStatus> deleteTechnology(@PathVariable Long id) throws TechnologyNotFoundException;
}
