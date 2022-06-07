package com.testback.controller;

import com.testback.exception.TechnologyNotFoundException;
import com.testback.models.views.TechnologyDto;
import com.testback.models.views.TechnologyDtoCreateUpdate;

import java.util.List;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/technology")
public interface TechnologyController {

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    TechnologyDto createTechnology(@Valid @RequestBody TechnologyDtoCreateUpdate technologyDtoCreateUpdate);

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    TechnologyDto updateTechnology(@Valid @RequestBody TechnologyDtoCreateUpdate technologyDtoCreateUpdate, @PathVariable Long id) throws TechnologyNotFoundException;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    List<TechnologyDto> findAll();

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deleteTechnology(@PathVariable Long id) throws TechnologyNotFoundException;
}
