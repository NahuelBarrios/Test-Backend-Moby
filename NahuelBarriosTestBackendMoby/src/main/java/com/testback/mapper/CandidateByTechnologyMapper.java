package com.testback.mapper;

import com.testback.models.entities.Candidate;
import com.testback.models.entities.CandidateByTechnology;
import com.testback.models.entities.Technology;
import com.testback.models.views.CandidateByTechnologyCreateUpdateDto;
import com.testback.models.views.CandidateByTechnologyDto;

public class CandidateByTechnologyMapper {

    private CandidateByTechnologyMapper() {
    }

    public static CandidateByTechnology mapDtoToModel(CandidateByTechnologyDto candidateByTechnologyDto) {
        return CandidateByTechnology.builder()
                .id(candidateByTechnologyDto.getId())
                .technology(candidateByTechnologyDto.getTechnology())
                .candidate(candidateByTechnologyDto.getCandidate())
                .experience(candidateByTechnologyDto.getExperience()).build();
    }

    public static CandidateByTechnology mapCreatingToModel(CandidateByTechnologyCreateUpdateDto candidateByTechnologyCreateUpdateDto,
                                                           Technology technology, Candidate candidate) {
        return CandidateByTechnology.builder()
                .candidate(candidate)
                .technology(technology)
                .experience(candidateByTechnologyCreateUpdateDto.getExperience()).build();
    }

    public static CandidateByTechnologyDto mapModelToDto(CandidateByTechnology candidateByTechnology) {
        return CandidateByTechnologyDto.builder()
                .id(candidateByTechnology.getId())
                .technology(candidateByTechnology.getTechnology())
                .candidate(candidateByTechnology.getCandidate())
                .experience(candidateByTechnology.getExperience()).build();
    }

}
