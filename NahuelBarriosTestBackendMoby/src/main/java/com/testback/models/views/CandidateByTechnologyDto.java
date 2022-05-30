package com.testback.models.views;

import com.testback.models.entities.Candidate;
import com.testback.models.entities.Technology;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CandidateByTechnologyDto {
    private Long id;
    private Candidate candidate;
    private Technology technology;
    private String experience;
}
