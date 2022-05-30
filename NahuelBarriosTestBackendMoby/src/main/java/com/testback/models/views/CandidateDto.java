package com.testback.models.views;

import com.testback.models.enums.DniType;
import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CandidateDto {
    private Long id;
    private String name;
    private String lastName;
    private DniType dniType;
    private String dni;
    private Date birthDate;
}
