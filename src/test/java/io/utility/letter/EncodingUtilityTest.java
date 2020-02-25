package io.utility.letter;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class EncodingUtilityTest {

	@BeforeClass
	public static void beforeClass() {
		System.out.println("This is the first excuted");
	}

	@Before
	public void before() {
		System.out.println("Before");
	}

	// @Test
	public void testOne() {
		

		System.out.println("This is the test");
	}

	@After
	public void after() {
		System.out.println("Before");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("This is the end excuted");
	}

}
