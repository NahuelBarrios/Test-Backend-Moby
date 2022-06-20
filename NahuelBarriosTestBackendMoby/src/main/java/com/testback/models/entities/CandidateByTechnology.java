package com.testback.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "candidatos_tecnologias")
public class CandidateByTechnology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_candidate_technology")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_candidato", nullable = false)
    private Candidate candidate;
    @ManyToOne
    @JoinColumn(name = "id_tecnologia", nullable = false)
    private Technology technology;
    @Column(name = "experiencia", nullable = false)
    private String experience;
}
