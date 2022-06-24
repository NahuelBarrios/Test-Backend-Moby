package com.testback.models.views;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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

    @NotBlank
    private String experience;
}
