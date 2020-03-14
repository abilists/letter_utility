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

	//@Test
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
	
	// @Test
	public void calculateMonthPeriodTest() {
		Date days = DateUtility.getDayInMillisBefore(30);
		String strDays = DateUtility.formatDate(days, "yyyy-MM-dd");
		System.out.println("days = " + strDays);
	}

	@Test
	public void cltDaysPeriodTest() {
		Date days1 = DateUtility.getDayInMillisBefore(2);
		System.out.println("Last day = " + DateUtility.formatDate(days1, "yyyy-MM-dd"));
		Date days2 = DateUtility.getDayInMillisBefore(1);
		System.out.println("Today = " + DateUtility.formatDate(days2, "yyyy-MM-dd"));
		
		System.out.println("========================================================= start ");
		long days3 = DateUtility.minusDateDays(days2, days1);
		
		for(int i=(int) days3 ; 1 < i ; i--) {
			System.out.println("days = " + DateUtility.formatDate(DateUtility.getDayInMillisBefore(i), "yyyy-MM-dd"));			
		}
		System.out.println("========================================================= end ");
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
