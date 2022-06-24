package com.testback.services.impl;

import com.testback.exception.CandidateByTechnologyNotFoundException;
import com.testback.exception.CandidateNotFoundException;
import com.testback.exception.TechnologyNotFoundException;
import com.testback.repository.CandidateByTechnologyRepository;
import com.testback.repository.CandidateRepository;
import com.testback.repository.TechnologyRepository;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;

import static com.testback.testutils.TestEntityFactory.getCandidate;
import static com.testback.testutils.TestEntityFactory.getCandidateByTechnology;
import static com.testback.testutils.TestEntityFactory.getCandidateByTechnologyCreateUpdateDto;
import static com.testback.testutils.TestEntityFactory.getListCandidateByTechnology;

import static com.testback.testutils.TestEntityFactory.getListCandidateByTechnologyProjection;
import static com.testback.testutils.TestEntityFactory.getTechnology;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CandidateByTechnologyServiceImpTest extends AbstractMvcTestServices {

    @InjectMocks
    CandidateByTechnologyServiceImp candidateByTechnologyServiceImp;

    @Mock
    CandidateByTechnologyRepository candidateByTechnologyRepository;

    @Mock
    CandidateRepository candidateRepository;

    @Mock
    TechnologyRepository technologyRepository;


    @Nested
    class createCandidateByTechnology {
        @Test
        void createCandidateByTechnologyReturnOkTest() {
            var candidateByTechnology = getCandidateByTechnology();
            var candidateByTechnologyCreate = getCandidateByTechnologyCreateUpdateDto();
            var candidate = getCandidate();
            var technology = getTechnology();

            when(candidateRepository.findById(candidateByTechnologyCreate.getCandidateId())).thenReturn(Optional.of(candidate));
            when(technologyRepository.findById(candidateByTechnologyCreate.getTechnologyId())).thenReturn(Optional.of(technology));
            when(candidateByTechnologyRepository.save(candidateByTechnology)).thenReturn(candidateByTechnology);
            var candidateByTechnologyDto = candidateByTechnologyServiceImp.createCandidateByTechnology(candidateByTechnologyCreate);
            assertEquals(candidateByTechnologyDto, candidateByTechnologyServiceImp.createCandidateByTechnology(candidateByTechnologyCreate));
        }

        @Test
        void createCandidateByTechnologyReturnCandidateNotFoundExceptionTest() {
            var candidateByTechnology = getCandidateByTechnology();
            var candidateByTechnologyCreate = getCandidateByTechnologyCreateUpdateDto();
            var candidate = getCandidate();
            when(candidateRepository.findById(candidateByTechnologyCreate.getCandidateId())).thenReturn(Optional.of(candidate));
            when(candidateByTechnologyRepository.save(candidateByTechnology)).thenReturn(candidateByTechnology);
            assertThrows(TechnologyNotFoundException.class, () -> candidateByTechnologyServiceImp.createCandidateByTechnology(candidateByTechnologyCreate));
        }

        @Test
        void createCandidateByTechnologyReturnTechnologyNotFoundExceptionTest() {
            var candidateByTechnology = getCandidateByTechnology();
            var candidateByTechnologyCreate = getCandidateByTechnologyCreateUpdateDto();
            var technology = getTechnology();
            when(technologyRepository.findById(candidateByTechnologyCreate.getTechnologyId())).thenReturn(Optional.of(technology));
            when(candidateByTechnologyRepository.save(candidateByTechnology)).thenReturn(candidateByTechnology);
            assertThrows(CandidateNotFoundException.class, () -> candidateByTechnologyServiceImp.createCandidateByTechnology(candidateByTechnologyCreate));
        }
    }

    @Nested
    class updateCandidateByTechnology {
        @Test
        void updateCandidateByTechnologyReturnOkTest() {
            var candidateByTechnology = getCandidateByTechnology();
            var candidateByTechnologyCreate = getCandidateByTechnologyCreateUpdateDto();
            var candidate = getCandidate();
            var technology = getTechnology();
            var id = 1L;

            when(candidateByTechnologyRepository.findById(candidateByTechnology.getId())).thenReturn(Optional.of(candidateByTechnology));
            when(candidateRepository.findById(candidate.getId())).thenReturn(Optional.of(candidate));
            when(technologyRepository.findById(technology.getId())).thenReturn(Optional.of(technology));
            when(candidateByTechnologyRepository.save(candidateByTechnology)).thenReturn(candidateByTechnology);

            var candidateByTechnologyDto = candidateByTechnologyServiceImp.updateCandidateByTechnology(candidateByTechnologyCreate,id);
            assertEquals(candidateByTechnologyDto, candidateByTechnologyServiceImp.updateCandidateByTechnology(candidateByTechnologyCreate,id));
        }

        @Test
        void updateCandidateByTechnologyReturnCandidateByTechnologyNotFoundExceptionTest() {

            var candidateByTechnology = getCandidateByTechnology();
            var candidateByTechnologyCreate = getCandidateByTechnologyCreateUpdateDto();
            var candidate = getCandidate();
            var technology = getTechnology();
            var id = 1L;

            when(candidateRepository.findById(candidate.getId())).thenReturn(Optional.of(candidate));
            when(technologyRepository.findById(technology.getId())).thenReturn(Optional.of(technology));
            when(candidateByTechnologyRepository.save(candidateByTechnology)).thenReturn(candidateByTechnology);

            assertThrows(CandidateByTechnologyNotFoundException.class, () -> candidateByTechnologyServiceImp.updateCandidateByTechnology(candidateByTechnologyCreate,id));
        }

        @Test
        void updateCandidateByTechnologyReturnCandidateNotFoundExceptionTest() {

            var candidateByTechnology = getCandidateByTechnology();
            var candidateByTechnologyCreate = getCandidateByTechnologyCreateUpdateDto();
            var technology = getTechnology();
            var id = 1L;

            when(candidateByTechnologyRepository.findById(candidateByTechnology.getId())).thenReturn(Optional.of(candidateByTechnology));
            when(technologyRepository.findById(technology.getId())).thenReturn(Optional.of(technology));
            when(candidateByTechnologyRepository.save(candidateByTechnology)).thenReturn(candidateByTechnology);

            assertThrows(CandidateNotFoundException.class, () -> candidateByTechnologyServiceImp.updateCandidateByTechnology(candidateByTechnologyCreate,id));
        }

        @Test
        void updateCandidateByTechnologyReturnTechnologyNotFoundExceptionTest() {

            var candidateByTechnology = getCandidateByTechnology();
            var candidateByTechnologyCreate = getCandidateByTechnologyCreateUpdateDto();
            var candidate = getCandidate();
            var id = 1L;

            when(candidateByTechnologyRepository.findById(candidateByTechnology.getId())).thenReturn(Optional.of(candidateByTechnology));
            when(candidateRepository.findById(candidate.getId())).thenReturn(Optional.of(candidate));
            when(candidateByTechnologyRepository.save(candidateByTechnology)).thenReturn(candidateByTechnology);

            assertThrows(TechnologyNotFoundException.class, () -> candidateByTechnologyServiceImp.updateCandidateByTechnology(candidateByTechnologyCreate,id));
        }
    }

    @Test
    void findAllTest() {
        var candidateByTechnologies = getListCandidateByTechnology();
        when(candidateByTechnologyRepository.findAll()).thenReturn(candidateByTechnologies);

        var candidateByTechnologiesDto = candidateByTechnologyServiceImp.findAll();
        assertEquals(candidateByTechnologiesDto, candidateByTechnologyServiceImp.findAll());
    }

    @Nested
    class deleteCandidateByTechnology {
        @Test
        void deleteCandidateByTechnologyReturnOkTest() {
            var id = 1L;
            var candidateByTechnology = getCandidateByTechnology();
            when(candidateByTechnologyRepository.findById(id)).thenReturn(Optional.of(candidateByTechnology));
            candidateByTechnologyServiceImp.deleteCandidateByTechnology(id);
            verify(candidateByTechnologyRepository, times(1)).delete(candidateByTechnology);
        }

        @Test
        void deleteCandidateByTechnologyReturnExceptionTest() {
            var id = 1L;
            assertThrows(CandidateByTechnologyNotFoundException.class, () -> candidateByTechnologyServiceImp.deleteCandidateByTechnology(id));
        }
    }


    @Test
    void findCandidatesByTechnologies() {
        var candidateByTechnologyProjection = getListCandidateByTechnologyProjection();
        var name = "java";
        when(candidateByTechnologyRepository.getCandidatesByTechnologies(name)).thenReturn(candidateByTechnologyProjection);

        assertEquals(candidateByTechnologyServiceImp.findCandidatesByTechnologies(name), candidateByTechnologyProjection);
    }
}
