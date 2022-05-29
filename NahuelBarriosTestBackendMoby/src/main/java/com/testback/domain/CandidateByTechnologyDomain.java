package com.testback.domain;

import com.testback.models.entities.Candidate;
import com.testback.models.entities.Technology;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CandidateByTechnologyDomain {
    private Long id;
    private Candidate candidate;
    private Technology technology;
    private String experience;
}
