package com.inditex.pruebatecnica;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * The type Pruebatecnica application tests.
 */
@SpringBootTest
class PruebatecnicaApplicationTests {

	/**
	 * Context loads.
	 */
	@Test
	void contextLoads() {
	}

	/**
	 * Main method should not throw exception.
	 */
	@Test
	void mainMethodShouldNotThrowException() {
		assertDoesNotThrow(() -> PruebatecnicaApplication.main(new String[]{}));
	}
}
