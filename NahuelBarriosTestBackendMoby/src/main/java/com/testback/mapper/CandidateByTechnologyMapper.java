package com.testback.mapper;

import com.testback.domain.CandidateByTechnologyDomain;
import com.testback.models.entities.Candidate;
import com.testback.models.entities.CandidateByTechnology;
import com.testback.models.entities.Technology;
import com.testback.models.views.CandidateByTechnologyCreateDto;
import com.testback.models.views.CandidateByTechnologyDto;

public class CandidateByTechnologyMapper {

    public static CandidateByTechnology mapDomainToModel(CandidateByTechnologyDomain candidateByTechnologyDomain){
        return CandidateByTechnology.builder()
                .id(candidateByTechnologyDomain.getId())
                .technology(candidateByTechnologyDomain.getTechnology())
                .candidate(candidateByTechnologyDomain.getCandidate())
                .experience(candidateByTechnologyDomain.getExperience()).build();
    }

    public static CandidateByTechnologyDomain mapModelToDomain(CandidateByTechnology candidateByTechnology){
        return CandidateByTechnologyDomain.builder()
                .id(candidateByTechnology.getId())
                .technology(candidateByTechnology.getTechnology())
                .candidate(candidateByTechnology.getCandidate())
                .experience(candidateByTechnology.getExperience()).build();
    }

    public static CandidateByTechnology mapCreatingToModel(CandidateByTechnologyCreateDto candidateByTechnologyCreateDto,
                                                           Technology technology, Candidate candidate){
        return CandidateByTechnology.builder()
                .candidate(candidate)
                .technology(technology)
                .experience(candidateByTechnologyCreateDto.getExperience()).build();
    }

    public static CandidateByTechnologyDto mapDomainToDto(CandidateByTechnologyDomain candidateByTechnologyDomain){
        return CandidateByTechnologyDto.builder()
                .id(candidateByTechnologyDomain.getId())
                .technology(candidateByTechnologyDomain.getTechnology())
                .candidate(candidateByTechnologyDomain.getCandidate())
                .experience(candidateByTechnologyDomain.getExperience()).build();
    }

}
