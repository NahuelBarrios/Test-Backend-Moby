package com.testback.repository;

import com.testback.models.entities.CandidateByTechnology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateByTechnologyRepository extends JpaRepository<CandidateByTechnology,Long> {
}
