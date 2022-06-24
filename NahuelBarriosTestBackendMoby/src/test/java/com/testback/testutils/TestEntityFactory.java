package com.testback.testutils;


import com.testback.models.entities.Candidate;
import com.testback.models.entities.CandidateByTechnology;
import com.testback.models.entities.Technology;
import com.testback.models.enums.DniType;
import com.testback.models.views.CandidateByTechnologyCreateUpdateDto;
import com.testback.models.views.CandidateByTechnologyDto;
import com.testback.models.views.CandidateDto;
import com.testback.models.views.CandidateDtoCreateUpdate;
import com.testback.models.views.TechnologyDto;
import com.testback.models.views.TechnologyDtoCreateUpdate;
import com.testback.projections.CandidateByTechnologyProjection;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class TestEntityFactory {

    public static CandidateDtoCreateUpdate getCandidateDtoCreateUpdate() {
        return CandidateDtoCreateUpdate.builder()
                .name("Nahuel")
                .lastName("Barrios")
                .dniType(DniType.DNI)
                .dni("123456").build();
    }

    public static CandidateDto getCandidateDto() {
        return CandidateDto.builder()
                .id(1L)
                .name("Nahuel")
                .lastName("Barrios")
                .dniType(DniType.DNI)
                .dni("123456").build();
    }

    public static Candidate getCandidate() {
        return Candidate.builder()
                .id(1L)
                .name("Nahuel")
                .lastName("Barrios")
                .dniType(DniType.DNI)
                .dni("123456")
                .birthDate(null).build();
    }

    public static List<Candidate> getListCandidates() {
        var candidates = new ArrayList<Candidate>();
        candidates.add(getCandidate());
        return candidates;
    }

    public static List<CandidateDto> getListCandidateDto() {
        var candidates = new ArrayList<CandidateDto>();
        candidates.add(getCandidateDto());
        return candidates;
    }

    public static Technology getTechnology() {
        return Technology.builder()
                .id(1L)
                .nameTechnology("el noba").build();
    }

    public static TechnologyDto getTechnologyDto() {
        return TechnologyDto.builder()
                .id(1L)
                .nameTechnology("el noba").build();
    }

    public static TechnologyDtoCreateUpdate getTechnologyCreatedUpdate() {
        return TechnologyDtoCreateUpdate.builder()
                .nameTechnology("el noba").build();
    }

    public static List<TechnologyDto> getListTechnologyDto() {
        var technologies = new ArrayList<TechnologyDto>();
        technologies.add(getTechnologyDto());
        return technologies;
    }

    public static List<Technology> getListTechnology() {
        var technologies = new ArrayList<Technology>();
        technologies.add(getTechnology());
        return technologies;
    }

    public static CandidateByTechnologyCreateUpdateDto getCandidateByTechnologyCreateUpdateDto() {
        return CandidateByTechnologyCreateUpdateDto.builder()
                .candidateId(1L)
                .technologyId(1L)
                .experience("1año").build();
    }

    public static CandidateByTechnologyDto getCandidateByTechnologyDto() {
        return CandidateByTechnologyDto.builder()
                .id(1L)
                .candidate(getCandidate())
                .technology(getTechnology())
                .experience("1año").build();
    }

    public static CandidateByTechnology getCandidateByTechnology() {
        return CandidateByTechnology.builder()
                .id(1L)
                .candidate(getCandidate())
                .technology(getTechnology())
                .experience("1año").build();
    }

    public static List<CandidateByTechnologyDto> getListCandidateByTechnologyDto() {
        var list = new ArrayList<CandidateByTechnologyDto>();
        list.add(getCandidateByTechnologyDto());
        return list;
    }

    public static List<CandidateByTechnology> getListCandidateByTechnology() {
        var list = new ArrayList<CandidateByTechnology>();
        list.add(getCandidateByTechnology());
        return list;
    }

    public static List<CandidateByTechnologyProjection> getListCandidateByTechnologyProjection(){
        var list = new ArrayList<CandidateByTechnologyProjection>();
        list.add(getCandidateByTechnologyProjection());
        return list;
    }

    public static CandidateByTechnologyProjection getCandidateByTechnologyProjection() {

        return new CandidateByTechnologyProjection() {

            @Override
            public String getName() {
                return "nahu";
            }

            @Override
            public String getLastName() {
                return "barrios";
            }

            @Override
            public DniType getDniType() {
                return DniType.DNI;
            }

            @Override
            public String getDni() {
                return "123";
            }

            @Override
            public LocalDate getBirthDate() {
                return LocalDate.now();
            }

            @Override
            public String getNameTechnology() {
                return "java";
            }

            @Override
            public String getExperience() {
                return "2 años";
            }

        };
    }

}