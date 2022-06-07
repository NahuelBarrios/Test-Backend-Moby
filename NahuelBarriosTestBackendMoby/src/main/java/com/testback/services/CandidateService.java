package com.testback.services;

import com.testback.domain.CandidateDomain;
import com.testback.exception.CandidateNotFoundException;

import java.util.List;

public interface CandidateService {

    CandidateDomain createCandidate(CandidateDomain candidateDomain);

    CandidateDomain updateCandidate(Long id,CandidateDomain candidateDomain) throws CandidateNotFoundException;

    List<CandidateDomain> findAll();

    void deleteCandidate(Long id) throws CandidateNotFoundException;
}
