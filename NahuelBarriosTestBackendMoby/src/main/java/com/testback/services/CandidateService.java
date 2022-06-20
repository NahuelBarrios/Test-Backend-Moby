package com.testback.services;

import com.testback.exception.CandidateNotFoundException;
import com.testback.models.views.CandidateDto;
import com.testback.models.views.CandidateDtoCreateUpdate;

import javax.transaction.Transactional;
import java.util.List;

public interface CandidateService {

    CandidateDto createCandidate(CandidateDtoCreateUpdate candidateDtoCreateUpdate);


    @Transactional
    CandidateDto updateCandidate(Long id, CandidateDtoCreateUpdate candidateDtoCreateUpdate) throws CandidateNotFoundException;

    List<CandidateDto> findAll();

    void deleteCandidate(Long id) throws CandidateNotFoundException;
}
