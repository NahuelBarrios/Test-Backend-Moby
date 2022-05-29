package com.testback.mapper;

import com.testback.domain.TechnologyDomain;
import com.testback.models.entities.Technology;

public class TechnologyMapper {

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
}
