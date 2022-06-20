package com.testback.controller.impl;

import com.testback.controller.TechnologyController;
import com.testback.models.views.TechnologyDto;
import com.testback.models.views.TechnologyDtoCreateUpdate;
import com.testback.services.impl.TechnologyServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TechnologyResource implements TechnologyController {

    @Autowired
    TechnologyServiceImp technologyServiceImp;

    @Override
    public ResponseEntity<TechnologyDto> createTechnology(TechnologyDtoCreateUpdate technologyDtoCreateUpdate) {
        return new ResponseEntity<>(technologyServiceImp.createTechnology(technologyDtoCreateUpdate), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<TechnologyDto> updateTechnology(TechnologyDtoCreateUpdate technologyDtoCreateUpdate, Long id) {
        return new ResponseEntity<>(technologyServiceImp.updateTechnology(technologyDtoCreateUpdate, id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<TechnologyDto>> findAll() {
        return new ResponseEntity<>(technologyServiceImp.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HttpStatus> deleteTechnology(Long id) {
        technologyServiceImp.deleteTechnology(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
