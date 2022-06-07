package com.testback.services;

import com.testback.domain.TechnologyDomain;
import com.testback.exception.TechnologyNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TechnologyService {
    @Transactional
    TechnologyDomain createTechnology(TechnologyDomain technologyDomain);

    @Transactional
    TechnologyDomain updateTechnology(TechnologyDomain technologyDomain,Long id) throws TechnologyNotFoundException;

    @Transactional
    List<TechnologyDomain> findAll();

    @Transactional
     void deleteTechnology(Long id) throws TechnologyNotFoundException;

}
