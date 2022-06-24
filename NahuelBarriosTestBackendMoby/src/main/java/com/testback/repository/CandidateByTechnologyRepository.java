package com.testback.repository;

import com.testback.models.entities.CandidateByTechnology;

import java.util.List;
import java.util.Optional;

import com.testback.projections.CandidateByTechnologyProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import static com.testback.utils.Querys.CANDIDATES_BY_TECHNOLOGIES;

@Repository
public interface CandidateByTechnologyRepository extends JpaRepository<CandidateByTechnology,Long> {
    Optional<CandidateByTechnology> findById(Long id);

    @Query(value = CANDIDATES_BY_TECHNOLOGIES,nativeQuery = true)
    List<CandidateByTechnologyProjection> getCandidatesByTechnologies(String name);
}
