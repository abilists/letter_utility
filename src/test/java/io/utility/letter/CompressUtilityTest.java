package io.utility.letter;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CompressUtilityTest {

	@BeforeClass
	public static void beforeClass() {
	}

	@Before
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

	@After
	public void after() {
		// System.out.println("Before");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("This is the end excuted");
	}

}
