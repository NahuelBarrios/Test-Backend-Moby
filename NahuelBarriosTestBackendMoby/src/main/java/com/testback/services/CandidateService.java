package com.testback.services;

import com.testback.domain.CandidateDomain;
import com.testback.exception.CandidateNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CandidateService {

    @Transactional
    CandidateDomain createCandidate(CandidateDomain candidateDomain);

    @Transactional
    CandidateDomain updateCandidate(Long id,CandidateDomain candidateDomain) throws CandidateNotFoundException;

    @Transactional
    List<CandidateDomain> findAll();

    @Transactional
    void deleteCandidate(Long id) throws CandidateNotFoundException;
}
