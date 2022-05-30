package com.testback.models.views;

import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CandidateDtoUpdate {
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @NotBlank
    private String lastName;
    @NotNull
    @NotBlank
    private String dniType;
    @NotNull
    @NotBlank
    private String dni;
    @NotNull
    @NotBlank
    private Date birthDate;
}
