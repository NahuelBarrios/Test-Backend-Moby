package com.testback.services.impl;

import com.testback.exception.TechnologyNotFoundException;
import com.testback.repository.TechnologyRepository;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;

import static com.testback.testutils.TestEntityFactory.getListTechnology;
import static com.testback.testutils.TestEntityFactory.getTechnology;
import static com.testback.testutils.TestEntityFactory.getTechnologyCreatedUpdate;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class TechnologyServiceImpTest extends AbstractMvcTestServices {

    @InjectMocks
    TechnologyServiceImp technologyServiceImp;
    @Mock
    TechnologyRepository technologyRepository;

    @Test
    void createTechnologyTest() {
        var technology = getTechnology();
        var technologyCreate = getTechnologyCreatedUpdate();
        when(technologyRepository.save(technology)).thenReturn(technology);

        var technologyDto = technologyServiceImp.createTechnology(technologyCreate);
        assertEquals(technologyDto, technologyServiceImp.createTechnology(technologyCreate));
    }

    @Nested
    class updateTechnologyTest {

        @Test
        void updateTechnologyTestOk() {
            var technologyUpdate = getTechnologyCreatedUpdate();
            var id = 1L;
            var technology = getTechnology();
            when(technologyRepository.findById(id)).thenReturn(Optional.of(technology));
            when(technologyRepository.save(technology)).thenReturn(technology);

            var technologyDto = technologyServiceImp.updateTechnology(technologyUpdate, id);
            assertEquals(technologyDto, technologyServiceImp.updateTechnology(technologyUpdate, id));

        }

        @Test
        void updateTechnologyTestException() {
            var technologyUpdate = getTechnologyCreatedUpdate();
            var id = 2L;
            assertThrows(TechnologyNotFoundException.class, () -> technologyServiceImp.updateTechnology(technologyUpdate, id));
        }
    }

    @Test
    void findAllTest() {
        var technologies = getListTechnology();
        when(technologyRepository.findAll()).thenReturn(technologies);

        var technologiesDto = technologyServiceImp.findAll();
        assertEquals(technologiesDto, technologyServiceImp.findAll());
    }

    @Nested
    class deleteTechnologyTest {
        @Test
        void deleteTechnologyTestOk() {
            var technology = getTechnology();
            var id = 1L;
            when(technologyRepository.findById(id)).thenReturn(Optional.of(technology));
            technologyServiceImp.deleteTechnology(id);
            verify(technologyRepository, times(1)).delete(technology);
        }

        @Test
        void deleteTechnologyTestException() {
            var id = 2L;
            assertThrows(TechnologyNotFoundException.class, () -> technologyServiceImp.deleteTechnology(id));
        }

    }
}