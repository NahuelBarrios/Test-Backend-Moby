package com.testback.domain;

import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CandidateDomain {
    private Long id;
    private String name;
    private String lastName;
    private String dniType;
    private String dni;
    private Date birthDate;
}
