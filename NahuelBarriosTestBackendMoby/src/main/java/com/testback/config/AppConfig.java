package com.testback.config;

import com.testback.repository.CandidateRepository;
import com.testback.services.CandidateService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    CandidateService candidateService(CandidateRepository candidateRepository){
        return new CandidateService(candidateRepository);
    }

}
