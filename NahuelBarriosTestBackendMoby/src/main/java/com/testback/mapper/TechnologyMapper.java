package com.testback.mapper;

import com.testback.domain.TechnologyDomain;
import com.testback.models.entities.Technology;
import com.testback.models.views.TechnologyDto;
import com.testback.models.views.TechnologyDtoCreateUpdate;

public class TechnologyMapper {

    private TechnologyMapper(){}

    public static Technology mapDomainToModel(TechnologyDomain technologyDomain){
        return Technology.builder()
                .id(technologyDomain.getId())
                .technology(technologyDomain.getTechnology()).build();
    }

    public static TechnologyDomain mapModelToDomain(Technology technology){
        return TechnologyDomain.builder()
                .id(technology.getId())
                .technology(technology.getTechnology()).build();
    }

    public static TechnologyDomain mapCreateUpdateToDomain(TechnologyDtoCreateUpdate technologyDtoCreateUpdate) {
        return TechnologyDomain.builder()
                .technology(technologyDtoCreateUpdate.getTechnology()).build();
    }

    public static TechnologyDto mapDomainToDto(TechnologyDomain technologyDomain){
        return TechnologyDto.builder()
                .id(technologyDomain.getId())
                .technology(technologyDomain.getTechnology()).build();
    }
}
