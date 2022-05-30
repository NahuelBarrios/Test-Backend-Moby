package com.testback.models.views;

import com.testback.models.enums.DniType;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CandidateDtoCreate {
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @NotBlank
    private String lastName;
    @NotNull
    @NotBlank
    private DniType dniType;
    @NotNull
    @NotBlank
    private String dni;
    @NotNull
    @NotBlank
    private Date birthDate;
}
