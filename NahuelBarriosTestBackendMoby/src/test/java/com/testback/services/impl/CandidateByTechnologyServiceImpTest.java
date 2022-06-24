package com.testback.services.impl;

import com.testback.mapper.CandidateByTechnologyMapper;
import com.testback.repository.CandidateByTechnologyRepository;
import com.testback.repository.CandidateRepository;
import com.testback.repository.TechnologyRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;

import static com.testback.testutils.TestEntityFactory.getCandidate;
import static com.testback.testutils.TestEntityFactory.getCandidateByTechnology;
import static com.testback.testutils.TestEntityFactory.getCandidateByTechnologyCreateUpdateDto;
import static com.testback.testutils.TestEntityFactory.getCandidateByTechnologyProjection;
import static com.testback.testutils.TestEntityFactory.getListCandidateByTechnology;
import static com.testback.testutils.TestEntityFactory.getListCandidateByTechnologyDto;
import static com.testback.testutils.TestEntityFactory.getListCandidateByTechnologyProjection;
import static com.testback.testutils.TestEntityFactory.getTechnology;
import static org.junit.jupiter.api.Assertions.assertEquals;
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


    /*@Test
    void createCandidateByTechnologyReturnOk() {
        var candidateByTechnology = getCandidateByTechnology();
        var candidateByTechnologyCreate = getCandidateByTechnologyCreateUpdateDto();
        var candidate = getCandidate();
        var technology = getTechnology();

        when(candidateRepository.findById(candidateByTechnologyCreate.getCandidateId())).thenReturn(Optional.of(candidate));
        when(technologyRepository.findById(candidateByTechnologyCreate.getTechnologyId())).thenReturn(Optional.of(technology));
        when(candidateByTechnologyRepository.save(candidateByTechnology)).thenReturn(candidateByTechnology);
        var candidateByTechnologyDto = candidateByTechnologyServiceImp.createCandidateByTechnology(candidateByTechnologyCreate);
        //verify(candidateByTechnologyServiceImp,times(1)).createCandidateByTechnology(candidateByTechnologyCreate);
        assertEquals(candidateByTechnologyDto,candidateByTechnologyServiceImp.createCandidateByTechnology(candidateByTechnologyCreate));
    }*/

    @Test
    void findAllTest() {
        var candidateByTechnologies = getListCandidateByTechnology();
        when(candidateByTechnologyRepository.findAll()).thenReturn(candidateByTechnologies);

        var candidateByTechnologiesDto = candidateByTechnologyServiceImp.findAll();
        assertEquals(candidateByTechnologiesDto, candidateByTechnologyServiceImp.findAll());
    }

    @Test
    void deleteCandidateByTechnologyTest() {
        var id = 1L;
        var candidateByTechnology = getCandidateByTechnology();
        when(candidateByTechnologyRepository.findById(id)).thenReturn(Optional.of(candidateByTechnology));
        candidateByTechnologyServiceImp.deleteCandidateByTechnology(id);
        verify(candidateByTechnologyRepository, times(1)).delete(candidateByTechnology);
    }

    @Test
    void findCandidatesByTechnologies() {
        var candidateByTechnologyProjection = getListCandidateByTechnologyProjection();
        var name = "java";
        when(candidateByTechnologyRepository.getCandidatesByTechnologies(name)).thenReturn(candidateByTechnologyProjection);

        assertEquals(candidateByTechnologyServiceImp.findCandidatesByTechnologies(name),candidateByTechnologyProjection);
    }
}
