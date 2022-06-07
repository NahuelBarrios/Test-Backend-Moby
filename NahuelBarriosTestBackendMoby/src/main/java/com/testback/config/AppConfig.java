package com.testback.config;

import com.testback.repository.CandidateByTechnologyRepository;
import com.testback.repository.CandidateRepository;
import com.testback.repository.TechnologyRepository;
import com.testback.services.impl.CandidateByTechnologyServiceImp;
import com.testback.services.impl.CandidateServiceImp;
import com.testback.services.impl.TechnologyServiceImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    CandidateServiceImp candidateService(CandidateRepository candidateRepository) {
        return new CandidateServiceImp(candidateRepository);
    }

    @Bean
    TechnologyServiceImp technologyService(TechnologyRepository technologyRepository) {
        return new TechnologyServiceImp(technologyRepository);
    }

    @Bean
    CandidateByTechnologyServiceImp candidateByTechnologyService(CandidateByTechnologyRepository candidateByTechnologyRepository,
                                                                 CandidateRepository candidateRepository,
                                                                 TechnologyRepository technologyRepository) {
        return new CandidateByTechnologyServiceImp(candidateByTechnologyRepository, candidateRepository, technologyRepository);
    }
}
