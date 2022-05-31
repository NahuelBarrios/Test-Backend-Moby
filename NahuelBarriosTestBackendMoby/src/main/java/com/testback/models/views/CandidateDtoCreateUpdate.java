package com.testback.models.views;

import com.testback.models.enums.DniType;
import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CandidateDtoCreateUpdate {

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String lastName;

    @NotNull
    private DniType dniType;

    @NotNull
    @NotBlank
    private String dni;

    @NotNull
    private LocalDate birthDate;
}
