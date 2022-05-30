package com.testback.config;

import com.testback.repository.CandidateByTechnologyRepository;
import com.testback.repository.CandidateRepository;
import com.testback.repository.TechnologyRepository;
import com.testback.services.CandidateByTechnologyService;
import com.testback.services.CandidateService;
import com.testback.services.TechnologyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    CandidateService candidateService(CandidateRepository candidateRepository){
        return new CandidateService(candidateRepository);
    }

    @Bean
    TechnologyService technologyService(TechnologyRepository technologyRepository){
        return new TechnologyService(technologyRepository);
    }

    @Bean
    CandidateByTechnologyService candidateByTechnologyService(CandidateByTechnologyRepository candidateByTechnologyRepository,
                                                              CandidateRepository candidateRepository,
                                                              TechnologyRepository technologyRepository){
        return new CandidateByTechnologyService(candidateByTechnologyRepository,candidateRepository,technologyRepository);
    }
}
