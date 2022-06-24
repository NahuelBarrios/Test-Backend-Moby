package com.testback.services.impl;

import com.testback.exception.CandidateNotFoundException;
import com.testback.repository.CandidateRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;

import static com.testback.testutils.TestEntityFactory.getCandidate;
import static com.testback.testutils.TestEntityFactory.getCandidateDtoCreateUpdate;
import static com.testback.testutils.TestEntityFactory.getListCandidates;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CandidateServiceImpTest extends AbstractMvcTestServices {

    @InjectMocks
    CandidateServiceImp candidateServiceImp;

    @Mock
    CandidateRepository candidateRepository;

    @Test
    void createCandidateTest() {
        var candidate = getCandidate();
        when(candidateRepository.save(candidate)).thenReturn(candidate);
        var candidateDto = candidateServiceImp.createCandidate(getCandidateDtoCreateUpdate());

        assertEquals(candidateDto, candidateServiceImp.createCandidate(getCandidateDtoCreateUpdate()));
    }

    @Test
    void findAllTest() {
        var candidates = getListCandidates();
        when(candidateRepository.findAll()).thenReturn(candidates);

        var candidatesDto = candidateServiceImp.findAll();
        assertEquals(candidatesDto, candidateServiceImp.findAll());
    }

    @Nested
    class deleteCandidateTest {

        @Test
        void deleteCandidateTestOk() {
            var candidate = getCandidate();
            var id = 1L;
            when(candidateRepository.findById(id)).thenReturn(Optional.of(candidate));
            candidateServiceImp.deleteCandidate(id);
            verify(candidateRepository, times(1)).delete(candidate);
        }

        @Test
        void deleteCandidateTestException() {
            var id = 2L;
            assertThrows(CandidateNotFoundException.class, () -> candidateServiceImp.deleteCandidate(id));
        }
    }

    @Nested
    class updateCandidateTest {

        @Test
        void updateCandidateTestOk() {
            var candidate = getCandidate();
            var id = 1L;
            when(candidateRepository.findById(id)).thenReturn(Optional.of(candidate));
            when(candidateRepository.save(candidate)).thenReturn(candidate);

            var candidateDto = candidateServiceImp.updateCandidate(id, getCandidateDtoCreateUpdate());
            assertEquals(candidateDto, candidateServiceImp.updateCandidate(id, getCandidateDtoCreateUpdate()));
        }

        @Test
        void updateCandidateTestException() {
            var id = 2L;
            var candidateCreateUpdate = getCandidateDtoCreateUpdate();
            Assert.assertThrows(CandidateNotFoundException.class, () -> candidateServiceImp.updateCandidate(id, candidateCreateUpdate));
        }
    }

}