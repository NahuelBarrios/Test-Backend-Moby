package com.testback.models.views;

import com.testback.models.enums.DniType;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CandidateDtoCreate {
    private String name;
    private String lastName;
    private DniType dniType;
    private String dni;
    private LocalDate birthDate;
}
