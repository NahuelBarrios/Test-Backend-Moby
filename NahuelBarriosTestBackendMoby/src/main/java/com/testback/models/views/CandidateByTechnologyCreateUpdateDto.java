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

    @NotNull
    @Min(1)
    private Long candidateId;

    @NotNull
    @Min(1)
    private Long technologyId;

    @NotNull
    @NotBlank
    private String experience;
}
