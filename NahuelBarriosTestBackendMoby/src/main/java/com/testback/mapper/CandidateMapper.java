package com.testback.mapper;

import com.testback.domain.CandidateDomain;
import com.testback.models.entities.Candidate;

public class CandidateMapper {

    public static Candidate mapDomainToModel(CandidateDomain candidateDomain){
        return Candidate.builder()
                .id(candidateDomain.getId())
                .name(candidateDomain.getName())
                .lastName(candidateDomain.getLastName())
                .dniType(candidateDomain.getDniType())
                .dni(candidateDomain.getDni())
                .birthDate(candidateDomain.getBirthDate()).build();
    }

    public static CandidateDomain mapModelToDomain(Candidate candidate){
        return CandidateDomain.builder()
                .id(candidate.getId())
                .name(candidate.getName())
                .lastName(candidate.getLastName())
                .dniType(candidate.getDniType())
                .dni(candidate.getDni())
                .birthDate(candidate.getBirthDate()).build();
    }
}
