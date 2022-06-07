package com.testback.services;

import com.testback.domain.CandidateByTechnologyDomain;
import com.testback.exception.CandidateByTechnologyNotFoundException;
import com.testback.exception.CandidateNotFoundException;
import com.testback.exception.TechnologyNotFoundException;
import com.testback.models.views.CandidateByTechnologyCreateUpdateDto;

import javax.transaction.Transactional;
import java.util.List;

public interface CandidateByTechnologyService {

    @Transactional
    CandidateByTechnologyDomain createCandidateByTechnology(CandidateByTechnologyCreateUpdateDto candidateByTechnologyCreateUpdateDto)
            throws CandidateNotFoundException, TechnologyNotFoundException, CandidateByTechnologyNotFoundException;

    @Transactional
    CandidateByTechnologyDomain updateCandidateByTechnology(CandidateByTechnologyCreateUpdateDto candidateByTechnologyCreateUpdateDto,
                                                            Long id) throws CandidateNotFoundException, TechnologyNotFoundException,
            CandidateByTechnologyNotFoundException;

    @Transactional
    List<CandidateByTechnologyDomain> findAll();

    @Transactional
    void deleteCandidateByTechnology(Long id) throws CandidateByTechnologyNotFoundException;
}
