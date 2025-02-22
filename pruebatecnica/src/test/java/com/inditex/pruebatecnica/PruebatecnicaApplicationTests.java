package com.inditex.pruebatecnica;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
class PruebatecnicaApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void mainMethodShouldNotThrowException() {
		assertDoesNotThrow(() -> PruebatecnicaApplication.main(new String[]{}));
	}
}
