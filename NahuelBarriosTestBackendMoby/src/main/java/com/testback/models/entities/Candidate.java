package com.testback.models.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.testback.models.enums.DniType;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="candidatos")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_candidatos")
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String name;

    @Column(name = "apellido", nullable = false)
    private String lastName;

    @Column(name = "tipo_dni", nullable = false)
    private DniType dniType;

    @Column(name = "numero_dni", nullable = false)
    private String dni;

    @Column(name = "fecha_nacimiento", nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate birthDate;

    @OneToMany(mappedBy = "candidate")
    @JsonBackReference
    private List<CandidateByTechnology> candidateByTechnologies;
}
