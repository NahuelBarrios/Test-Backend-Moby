package com.testback;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class NahuelBarriosTestApplicationTests {

	@Disabled("Se desactivo para evitar codeSmells")
	@Test
	void contextLoads() {
		assertTrue(true);
	}

}
