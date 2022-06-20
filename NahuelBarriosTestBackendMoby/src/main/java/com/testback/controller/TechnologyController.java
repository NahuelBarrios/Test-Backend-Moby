package com.testback.controller;

import com.testback.exception.TechnologyNotFoundException;
import com.testback.models.views.TechnologyDto;
import com.testback.models.views.TechnologyDtoCreateUpdate;

import java.util.List;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/technology")
public interface TechnologyController {

    @PostMapping("/add")
    ResponseEntity<TechnologyDto> createTechnology(@Valid @RequestBody TechnologyDtoCreateUpdate technologyDtoCreateUpdate);

    @PutMapping("/{id}")
    ResponseEntity<TechnologyDto> updateTechnology(@Valid @RequestBody TechnologyDtoCreateUpdate technologyDtoCreateUpdate, @PathVariable Long id) throws TechnologyNotFoundException;

    @GetMapping()
    ResponseEntity<List<TechnologyDto>> findAll();

    @DeleteMapping("/{id}")
    ResponseEntity<HttpStatus> deleteTechnology(@PathVariable Long id) throws TechnologyNotFoundException;
}
