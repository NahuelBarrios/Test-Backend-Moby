package com.testback.models.views;

import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CandidateDto {
    private Long id;
    private String name;
    private String lastName;
    private String dniType;
    private String dni;
    private Date birthDate;
}
