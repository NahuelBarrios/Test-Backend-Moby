package com.testback.projections;

import com.testback.models.enums.DniType;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;

public interface CandidateByTechnologyProjection {

    @Value("#{target.nombre}")
    String getName();

    @Value("#{target.apellido}")
    String getLastName();

    @Value("#{target.tipo_dni}")
    DniType getDniType();

    @Value("#{target.numero_dni}")
    String getDni();

    @Value("#{target.fecha_nacimiento}")
    LocalDate getBirthDate();

    @Value("#target.nombre_tecnologia")
    String getNameTechnology();

    @Value("#target.experiencia")
    String getExperience();
}
