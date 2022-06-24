package com.testback.controller;

import com.testback.services.impl.CandidateByTechnologyServiceImp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.google.gson.Gson;
import org.springframework.http.MediaType;

import static com.testback.testutils.TestEntityFactory.getCandidateByTechnologyCreateUpdateDto;
import static com.testback.testutils.TestEntityFactory.getCandidateByTechnologyDto;
import static com.testback.testutils.TestEntityFactory.getListCandidateByTechnologyDto;
import static com.testback.testutils.TestEntityFactory.getListCandidateByTechnologyProjection;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CandidateByTechnologyResourceTest extends AbstractMVCTest {

    @MockBean
    CandidateByTechnologyServiceImp candidateByTechnologyServiceImpl;

    @Test
    void createCandidateByTechnologyTest() throws Exception {
        var candidateByTechnologyCreateUpdateDto = getCandidateByTechnologyCreateUpdateDto();
        var candidateByTechnologyDto = getCandidateByTechnologyDto();
        when(candidateByTechnologyServiceImpl.createCandidateByTechnology(candidateByTechnologyCreateUpdateDto)).thenReturn(candidateByTechnologyDto);

        String candidateByTechnologyGson = new Gson().toJson(candidateByTechnologyDto);

        mockMvc.perform(post("/candidatebytechnology/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(candidateByTechnologyGson))
                .andExpect(status().isCreated());
    }

    @Test
    void updateCandidateByTechnology() throws Exception {
        var candidateByTechnologyCreateUpdateDto = getCandidateByTechnologyCreateUpdateDto();
        var candidateByTechnologyDto = getCandidateByTechnologyDto();
        var id = 1L;
        when(candidateByTechnologyServiceImpl.updateCandidateByTechnology(candidateByTechnologyCreateUpdateDto, id)).thenReturn(candidateByTechnologyDto);

        String candidateByTechnologyGson = new Gson().toJson(candidateByTechnologyDto);

        mockMvc.perform(put("/candidatebytechnology/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(candidateByTechnologyGson))
                .andExpect(status().isOk());
    }

    @Test
    void findAllTest() throws Exception {
        var candidateByTechnologies = getListCandidateByTechnologyDto();
        when(candidateByTechnologyServiceImpl.findAll()).thenReturn(candidateByTechnologies);

        mockMvc.perform(get("/candidatebytechnology")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void deleteCandidateByTechnologyTest() throws Exception {
        var id = 1L;
        candidateByTechnologyServiceImpl.deleteCandidateByTechnology(id);
        verify(candidateByTechnologyServiceImpl, times(1)).deleteCandidateByTechnology(id);

        mockMvc.perform(delete("/candidatebytechnology/1"))
                .andExpect(status().isOk());
    }

    @Test
    void findCandidatesByTechnologiesReturnOkTest() throws Exception{
        var name = "java";
        var candidateProjection = getListCandidateByTechnologyProjection();

        when(candidateByTechnologyServiceImpl.findCandidatesByTechnologies(name)).thenReturn(candidateProjection);
        mockMvc.perform(get("/candidatebytechnology/search/java")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
