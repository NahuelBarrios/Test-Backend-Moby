package com.testback.services.impl;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public abstract class AbstractMvcTestServices {

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

}
