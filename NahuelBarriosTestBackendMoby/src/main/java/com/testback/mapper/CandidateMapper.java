package com.testback.mapper;

import com.testback.models.entities.Candidate;
import com.testback.models.views.CandidateDto;
import com.testback.models.views.CandidateDtoCreateUpdate;

public class CandidateMapper {
    private CandidateMapper() {
    }

    public static Candidate mapCreateUpdateToModel(CandidateDtoCreateUpdate candidateDtoCreateUpdate) {
        return Candidate.builder()
                .name(candidateDtoCreateUpdate.getName())
                .lastName(candidateDtoCreateUpdate.getLastName())
                .dniType(candidateDtoCreateUpdate.getDniType())
                .dni(candidateDtoCreateUpdate.getDni())
                .birthDate(candidateDtoCreateUpdate.getBirthDate()).build();
    }

    public static CandidateDto mapModelToDto(Candidate candidate) {
        return CandidateDto.builder()
                .id(candidate.getId())
                .name(candidate.getName())
                .lastName(candidate.getLastName())
                .dniType(candidate.getDniType())
                .dni(candidate.getDni())
                .birthDate(candidate.getBirthDate()).build();
    }

    public static Candidate mapDtoToModel(CandidateDto candidateDto) {
        return Candidate.builder()
                .id(candidateDto.getId())
                .name(candidateDto.getName())
                .lastName(candidateDto.getLastName())
                .dniType(candidateDto.getDniType())
                .dni(candidateDto.getDni())
                .birthDate(candidateDto.getBirthDate()).build();
    }

}
