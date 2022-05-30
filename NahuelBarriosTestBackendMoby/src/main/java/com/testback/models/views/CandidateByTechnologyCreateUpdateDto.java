package com.testback.models.views;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CandidateByTechnologyCreateUpdateDto {
    private Long candidateId;
    private Long technologyId;
    private String experience;
}
