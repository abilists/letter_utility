package io.utility.letter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;

public class EncodingUtilityTest {

	@BeforeAll
	public static void beforeClass() {
		System.out.println("This is the first excuted");
	}

	@BeforeEach
	public void before() {
		System.out.println("Before");
	}

	// @Test
	public void testOne() {
		

		System.out.println("This is the test");
	}

	@AfterEach
	public void after() {
		System.out.println("Before");
	}

	@AfterAll
	public static void afterClass() {
		System.out.println("This is the end excuted");
	}

}
