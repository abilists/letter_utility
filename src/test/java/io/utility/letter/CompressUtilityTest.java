package io.utility.letter;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CompressUtilityTest {

	@BeforeAll
	public static void beforeClass() {
	}

	@BeforeEach
	public void before() {
	}

	@Test
	public void compressByFilesTest() {
		
		try {
			String file1 = "src/test/resources/test1.txt";
	        String file2 = "src/test/resources/test2.txt";
	        final List<String> srcFiles = Arrays.asList(file1, file2);
			
	        String parentPath = "src/test/resources";

			CompressUtility.compressByFiles(srcFiles, parentPath, "testZip.zip");

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("This is the test");
	}

	// @Test
	public void compressTest() {
		
		try {

			byte[] byteArray = CompressUtility.compress("testtesttesttest");

			System.out.println("byteArray=>" + byteArray);

			String originString = CompressUtility.deCompress(byteArray);

			// System.out.println("==" + new String(byteArray) + "==");
			System.out.println(originString);

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("This is the test");
	}

	@AfterEach
	public void after() {
		// System.out.println("Before");
	}

	@AfterAll
	public static void afterClass() {
		System.out.println("This is the end excuted");
	}

}
