package com.testback.controller;


import com.testback.services.impl.CandidateServiceImp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.google.gson.Gson;
import org.springframework.http.MediaType;

import static com.testback.testutils.TestEntityFactory.getCandidateDto;
import static com.testback.testutils.TestEntityFactory.getCandidateDtoCreateUpdate;
import static com.testback.testutils.TestEntityFactory.getListCandidateDto;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CandidateResourceTest extends AbstractMVCTest {

    @MockBean
    CandidateServiceImp candidateServiceImp;

    @Test
    void createCandidateTest() throws Exception {
        var candidateDto = getCandidateDto();
        var candidateCreateUpdate = getCandidateDtoCreateUpdate();
        when(candidateServiceImp.createCandidate(candidateCreateUpdate)).thenReturn(candidateDto);

        String candidateGson = new Gson().toJson(candidateDto);

        mockMvc.perform(post("/candidate/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(candidateGson))
                .andExpect(status().isCreated());
    }

    @Test
    void updateCandidateTest() throws Exception {
        var id = 1L;
        var candidateDto = getCandidateDto();
        var candidateCreateUpdate = getCandidateDtoCreateUpdate();
        candidateServiceImp.updateCandidate(id, candidateCreateUpdate);

        String candidateGson = new Gson().toJson(candidateDto);

        mockMvc.perform(put("/candidate/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(candidateGson))
                .andExpect(status().isOk());
    }

    @Test
    void findAllTest() throws Exception {
        var candidates = getListCandidateDto();
        when(candidateServiceImp.findAll()).thenReturn(candidates);

        mockMvc.perform(get("/candidate")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void deleteCandidateTest() throws Exception {
        var id = 1L;
        candidateServiceImp.deleteCandidate(id);
        verify(candidateServiceImp, atLeastOnce()).deleteCandidate(id);

        mockMvc.perform(delete("/candidate/1"))
                .andExpect(status().isOk());
    }
}
