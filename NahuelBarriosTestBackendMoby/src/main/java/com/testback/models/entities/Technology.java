package com.testback.models.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="tecnologias")
public class Technology {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tecnologias")
    private Long id;
    @Column(name = "nombre_tecnologia", nullable = false)
    private String nameTechnology;
    @OneToMany(mappedBy = "technology")
    @JsonBackReference
    private List<CandidateByTechnology> candidateByTechnologies;
}
