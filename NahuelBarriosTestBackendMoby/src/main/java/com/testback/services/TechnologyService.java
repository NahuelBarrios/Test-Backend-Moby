package com.testback.services;

import com.testback.exception.TechnologyNotFoundException;
import com.testback.models.views.TechnologyDto;
import com.testback.models.views.TechnologyDtoCreateUpdate;

import java.util.List;

public interface TechnologyService {
    TechnologyDto createTechnology(TechnologyDtoCreateUpdate technologyDtoCreateUpdate);

    TechnologyDto updateTechnology(TechnologyDtoCreateUpdate technologyDtoCreateUpdate, Long id) throws TechnologyNotFoundException;

    List<TechnologyDto> findAll();

    void deleteTechnology(Long id) throws TechnologyNotFoundException;

}
