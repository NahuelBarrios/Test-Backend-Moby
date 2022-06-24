package com.testback.controller;

import com.google.gson.Gson;
import com.testback.services.impl.TechnologyServiceImp;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import static com.testback.testutils.TestEntityFactory.getListTechnologyDto;
import static com.testback.testutils.TestEntityFactory.getTechnologyCreatedUpdate;
import static com.testback.testutils.TestEntityFactory.getTechnologyDto;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class TechnologyResourceTest extends AbstractMVCTest {

    @MockBean
    TechnologyServiceImp technologyServiceImp;

    @Test
    void createTechnologyTest() throws Exception {
        var technologyCreated = getTechnologyCreatedUpdate();
        var technologyDto = getTechnologyDto();
        when(technologyServiceImp.createTechnology(technologyCreated)).thenReturn(technologyDto);

        String technologyGson = new Gson().toJson(technologyDto);

        mockMvc.perform(post("/technology/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(technologyGson))
                .andExpect(status().isCreated());
    }

    @Test
    void updateTechnologyTest() throws Exception {
        var technologyCreated = getTechnologyCreatedUpdate();
        var id = 1L;
        var technologyDto = getTechnologyDto();
        when(technologyServiceImp.updateTechnology(technologyCreated, id)).thenReturn(technologyDto);

        String technologyGson = new Gson().toJson(technologyDto);

        mockMvc.perform(put("/technology/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(technologyGson))
                .andExpect(status().isOk());
    }

    @Test
    void findAllTest() throws Exception {
        var technologies = getListTechnologyDto();
        when(technologyServiceImp.findAll()).thenReturn(technologies);

        mockMvc.perform(get("/technology")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void deleteTechnologyTest() throws Exception {
        var id = 1L;
        technologyServiceImp.deleteTechnology(id);
        verify(technologyServiceImp, times(1)).deleteTechnology(id);

        mockMvc.perform(delete("/technology/1"))
                .andExpect(status().isOk());
    }

}
