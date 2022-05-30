package com.testback.controller;

import com.testback.models.views.TechnologyDto;
import com.testback.models.views.TechnologyDtoCreateUpdate;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface TechnologyController {

    @PostMapping("/technology")
    @ResponseStatus(HttpStatus.CREATED)
    TechnologyDto createTechnology(@Valid @RequestBody TechnologyDtoCreateUpdate technologyDtoCreateUpdate);

    @PutMapping("/technology/{id}")
    @ResponseStatus(HttpStatus.OK)
    TechnologyDto updateTechnology(@Valid @RequestBody TechnologyDtoCreateUpdate technologyDtoCreateUpdate, @PathVariable Long id);

}
