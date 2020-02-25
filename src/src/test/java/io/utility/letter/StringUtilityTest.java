package io.utility.letter;

import java.io.BufferedReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StringUtilityTest {

	@BeforeClass
	public static void beforeClass() {
		System.out.println("This is the first excuted");
	}

	@Before
	public void before() {
		System.out.println("Before");
	}

	// @Test
	public void testZero() {
		try {

			BufferedReader fsReader = null;
			LineNumberReader lnReader = null;
			String strReadResult = null;

			try {

				fsReader = FileUtility.readFileBuffered("/Users/test/test.txt", "UTF-8");
			    lnReader = new LineNumberReader(fsReader);
				while((strReadResult = lnReader.readLine()) != null) {
					System.out.println(" strReadResult >>> " + strReadResult);
				}

			} catch (Exception e) {
				System.out.println(e);
			}

			String strWrite = "test";
			FileUtility.saveFileString("/Users/test/test.txt", null, strWrite);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// @Test
	public void testOne() {

		try {

			BufferedReader fsReader = null;
			LineNumberReader lnReader = null;
			String strReadResult = null;

			List<String> result = new ArrayList<String>();
			try {

				fsReader = FileUtility.readFileBuffered("/Users/test/test.csv", "UTF-8");
			    lnReader = new LineNumberReader(fsReader);

				while((strReadResult = lnReader.readLine()) != null) {
					String [] strLine = strReadResult.split(",");
					// �뿃 - no, so pass  university for graduate school
					if(strLine.length < 2 || !strLine[1].trim().equals("�뿃")) {
						System.out.println("�뿃 - no");
						continue;
					}

//					// �뿃 - no, so pass graduate school for university 
//					if(strLine.length > 1 && strLine[1].trim().equals("�뿃")) {
//						// System.out.println("�뿃 - is");
//						continue;
//					}

					boolean duplicate = false;
					for (String str : result) {
						if (str.equals(strLine[0])) {
							duplicate = true;
							break;
						}
					}
					if (!duplicate) {
						result.add(strLine[0]);
					}
				}

			} catch (Exception e) {
				System.out.println(e);
			}

			int cnt = 0;
		    StringBuffer sb = new StringBuffer();

			for(String str2 : result) {
				cnt++;
				sb.append(str2).append("\r");
				System.out.println("name >>> " + str2 + ", count >>>>" + cnt);
			}
			FileUtility.saveFileString("/Users/test/test1.csv", null, sb.toString(), "UTF-8");
			// Assert.assertEquals("test", resutl);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("This is the test");
	}

	//@Test
	public void testTwo() {

		try {
			BufferedReader fsReaderNew = null;
			BufferedReader fsReaderOld = null;

			LineNumberReader lnReaderNew = null;
			LineNumberReader lnReaderOld = null;
			String strReadResultNew = null;
			String strReadResultOld = null;

			List<String> result = new ArrayList<String>();
			try {

				fsReaderNew = FileUtility.readFileBuffered("/Users/test/test1.csv", "UTF-8");
				fsReaderOld = FileUtility.readFileBuffered("/Users/test/test2.csv", "UTF-8");
			    lnReaderNew = new LineNumberReader(fsReaderNew);
			    lnReaderOld = new LineNumberReader(fsReaderOld);

			    List<String> strArrayA = new ArrayList<String>();
				while((strReadResultOld = fsReaderOld.readLine()) != null) {
					strArrayA.add(strReadResultOld);
				}

				List<String> strArrayB = new ArrayList<String>();
				while((strReadResultNew = lnReaderNew.readLine()) != null) {
					strArrayB.add(strReadResultNew);
				}

				List<String> bothList = StringUtility.compareString(strArrayA, strArrayB, StringUtility.LEFT);
				
				int cnt = 0;
				StringBuffer sb = new StringBuffer();
				for(String str: bothList) {
					cnt++;
					sb.append(str).append("\r");
					System.out.println("same = " + str + ", cnt= " + cnt);
				}

				FileUtility.saveFileString("/Users/test/result1-result2-left.csv", null, sb.toString(), "UTF-8");

			} catch (Exception e) {
				System.out.println(e);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println("This is the test");
	}

	@Test
	public void getExtFileNameTest() {		
		System.out.println(StringUtility.getExtFileName("test.min.txt"));
	}

	@Test
	public void getFileNameWithExt() {		
		System.out.println(StringUtility.getFileNameWithExt("aa.bb.jpg", "png"));
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
