package com.testback.services;

import com.testback.domain.TechnologyDomain;
import com.testback.exception.TechnologyNotFoundException;

import java.util.List;

public interface TechnologyService {
    TechnologyDomain createTechnology(TechnologyDomain technologyDomain);

    TechnologyDomain updateTechnology(TechnologyDomain technologyDomain,Long id) throws TechnologyNotFoundException;

    List<TechnologyDomain> findAll();

     void deleteTechnology(Long id) throws TechnologyNotFoundException;

}
