package io.utility.letter;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DateUtilityTest {

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
		
		try {

			System.out.println("abcd 1 >>> " + DateUtility.getNowMonth(-1));
			SimpleDateFormat format	= new SimpleDateFormat("yyyy-MM-dd");
			String date = format.format(DateUtility.getStartDayOfMonth(-1));
			System.out.println("abcd 2 >>> " + date);

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("This is the test");
	}

	@Test
	public void formatDateTest() {
		
		try {

			Date date = DateUtility.getNowTime();
			String formatedDate = DateUtility.formatDate(date, "Y");

			System.out.println(formatedDate);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("This is the test");
	}

	//@Test
	public void convertMillisToDate() {

		try {

			long longDate = 33060000;

			long diffHours = longDate / (60 * 60 * 1000) % 24;

			System.out.println(diffHours);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("This is the test");
	}
	
	@Test
	public void calculateMonthPeriodTest() {
		int period = DateUtility.calculateMonthPeriod(2016, 10, 2017, 5);
		Assert.assertEquals(8, period);
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
