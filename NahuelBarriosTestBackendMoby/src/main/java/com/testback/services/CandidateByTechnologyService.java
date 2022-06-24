package com.testback.services;

import com.testback.exception.CandidateByTechnologyNotFoundException;
import com.testback.exception.CandidateNotFoundException;
import com.testback.exception.TechnologyNotFoundException;
import com.testback.models.views.CandidateByTechnologyCreateUpdateDto;
import com.testback.models.views.CandidateByTechnologyDto;
import com.testback.projections.CandidateByTechnologyProjection;

import java.util.List;

public interface CandidateByTechnologyService {

    CandidateByTechnologyDto createCandidateByTechnology(CandidateByTechnologyCreateUpdateDto candidateByTechnologyCreateUpdateDto)
            throws CandidateNotFoundException, TechnologyNotFoundException;

    CandidateByTechnologyDto updateCandidateByTechnology(CandidateByTechnologyCreateUpdateDto candidateByTechnologyCreateUpdateDto,
                                                         Long id) throws CandidateNotFoundException, TechnologyNotFoundException,
            CandidateByTechnologyNotFoundException;

    List<CandidateByTechnologyDto> findAll();

    void deleteCandidateByTechnology(Long id) throws CandidateByTechnologyNotFoundException;

    List<CandidateByTechnologyProjection> findCandidatesByTechnologies(String nameTechnology);
}
