package com.testback.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TechnologyDomain {
    private Long id;
    private String technology;
}
