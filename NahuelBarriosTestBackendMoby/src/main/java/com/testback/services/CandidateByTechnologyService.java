package com.testback.services;

import com.testback.domain.CandidateByTechnologyDomain;
import com.testback.exception.CandidateByTechnologyNotFoundException;
import com.testback.exception.CandidateNotFoundException;
import com.testback.exception.TechnologyNotFoundException;
import com.testback.models.views.CandidateByTechnologyCreateUpdateDto;

import java.util.List;

public interface CandidateByTechnologyService {

    CandidateByTechnologyDomain createCandidateByTechnology(CandidateByTechnologyCreateUpdateDto candidateByTechnologyCreateUpdateDto)
            throws CandidateNotFoundException, TechnologyNotFoundException, CandidateByTechnologyNotFoundException;

    CandidateByTechnologyDomain updateCandidateByTechnology(CandidateByTechnologyCreateUpdateDto candidateByTechnologyCreateUpdateDto,
                                                            Long id) throws CandidateNotFoundException, TechnologyNotFoundException,
            CandidateByTechnologyNotFoundException;

    List<CandidateByTechnologyDomain> findAll();

    void deleteCandidateByTechnology(Long id) throws CandidateByTechnologyNotFoundException;
}
