package com.testback.mapper;

import com.testback.models.entities.Technology;
import com.testback.models.views.TechnologyDto;
import com.testback.models.views.TechnologyDtoCreateUpdate;

public class TechnologyMapper {

    private TechnologyMapper() {
    }

    public static Technology mapDtoToModel(Technology technology) {
        return Technology.builder()
                .id(technology.getId())
                .nameTechnology(technology.getNameTechnology()).build();
    }

    public static Technology mapCreateUpdateToModel(TechnologyDtoCreateUpdate technologyDtoCreateUpdate) {
        return Technology.builder()
                .nameTechnology(technologyDtoCreateUpdate.getNameTechnology()).build();
    }

    public static TechnologyDto mapModelToDto(Technology technology) {
        return TechnologyDto.builder()
                .id(technology.getId())
                .nameTechnology(technology.getNameTechnology()).build();
    }
}
