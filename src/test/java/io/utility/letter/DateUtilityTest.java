package io.utility.letter;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DateUtilityTest {

	@BeforeClass
	public static void beforeClass() {
		// System.out.println("This is the first excuted");
	}

	@Before
	public void before() {
		SimpleDateFormat format	= new SimpleDateFormat("yyyy-MM-dd");
		String date = format.format(DateUtility.getEndDayOfMonth(-12));
	}

	//@Test
	public void testOne() {
		
		try {

			Date startDate = DateUtility.getNowTime();
			long startTime = startDate.getTime();

			System.out.println("abcd 1 >>> " + startTime);
			SimpleDateFormat format	= new SimpleDateFormat("yyyy-MM-dd");
			String date = format.format(DateUtility.getStartDayOfMonth(-1));
			
			Thread.sleep(2000);

			Date endDate = DateUtility.getNowTime();
			long endTime = endDate.getTime();

			System.out.println("abcd 2 >>> " + endTime);

			long diff = endTime - startTime;
			
			System.out.println("abcd 3 >>> " + diff);
			
			System.out.println("abcd 4 >>> " + DateUtility.getDurationBreakdown(diff));

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("This is the test");
	}

	//@Test
	public void formatDateTest() {
		
		try {

			Date nowDate = DateUtility.getNowTime();
			long lngNowTime = nowDate.getTime();
			
			Date cmdDate = DateUtility.getDaySet(2020, 6, 18, 22, 50, 0);
			long lngCmdDate = cmdDate.getTime(); 

			int diffDays = DateUtility.minusDateMinutes(nowDate, cmdDate);

			System.out.println("test => " + diffDays);

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
	public void cltTimePeriodTest() {
		Date days = DateUtility.getDayInMillisBefore(30);
		String strDays = DateUtility.formatDate(days, "yyyy-MM-dd");
		System.out.println("days = " + strDays);
	}

	// @Test
	public void cltDaysPeriodTest() {
		Date days1 = DateUtility.getDayInMillisBefore(2);
		System.out.println("days1 = " + DateUtility.formatDate(days1, "yyyy-MM-dd"));
		Date days2 = DateUtility.getDayInMillisBefore(1);
		System.out.println("days2 = " + DateUtility.formatDate(days2, "yyyy-MM-dd"));
		
		System.out.println("========================================================= start ");
		long days3 = DateUtility.minusDateDays(days2, days1);
		
		for(int i=(int) days3 ; 1 < i ; i--) {
			System.out.println("days = " + DateUtility.formatDate(DateUtility.getDayInMillisBefore(i), "yyyy-MM-dd"));			
		}
		System.out.println("========================================================= end ");
	}

	// @Test
	public void getCalendarTodayTest() {
		Calendar clr = DateUtility.getCalendarToday(2020, 07, 10, 0);
		int strWeek = clr.get(Calendar.DAY_OF_WEEK);
		System.out.println("strWeek => " + strWeek);
		assertEquals(6, strWeek);
	}

	@Test
	public void getDaySet() {
		
		
		String strDate = "202207052359";
		
		
		String strYear = strDate.substring(0, 4);
		System.out.println("strYear => " + strYear);
		
		String strMonth = strDate.substring(4, 6);
		System.out.println("strMonth => " + strMonth);

		String strDay = strDate.substring(6, 8);
		System.out.println("strDay => " + strDay);
		
		String strHousr = strDate.substring(8, 10);
		System.out.println("strMonth => " + strHousr);
		
		String strMinute = strDate.substring(10, 12);
		System.out.println("strMinute => " + strMinute);
		
		
		
		Date date = DateUtility.getDaySet(strDate);
		String rtsDate = DateUtility.formatDate(date, "yyyy-MM-dd HH:mm:ss");
		System.out.println("rtsDate => " + rtsDate);
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
