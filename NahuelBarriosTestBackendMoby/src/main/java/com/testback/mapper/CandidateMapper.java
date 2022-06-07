package com.testback.mapper;

import com.testback.domain.CandidateDomain;
import com.testback.models.entities.Candidate;
import com.testback.models.views.CandidateDto;
import com.testback.models.views.CandidateDtoCreateUpdate;

public class CandidateMapper {
    private CandidateMapper(){}

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

    public static CandidateDomain mapCreateUpdateToDomain(CandidateDtoCreateUpdate candidateDtoCreateUpdate){
        return CandidateDomain.builder()
                .name(candidateDtoCreateUpdate.getName())
                .lastName(candidateDtoCreateUpdate.getLastName())
                .dniType(candidateDtoCreateUpdate.getDniType())
                .dni(candidateDtoCreateUpdate.getDni())
                .birthDate(candidateDtoCreateUpdate.getBirthDate()).build();
    }

    public static CandidateDto mapDomainToDto(CandidateDomain candidateDomain){
        return CandidateDto.builder()
                .id(candidateDomain.getId())
                .name(candidateDomain.getName())
                .lastName(candidateDomain.getLastName())
                .dniType(candidateDomain.getDniType())
                .dni(candidateDomain.getDni())
                .birthDate(candidateDomain.getBirthDate()).build();
    }

}
