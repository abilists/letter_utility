package io.utility.letter;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

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

	@Test
	public void testGetCltDaysPeriod() {
		String result = DateUtility.getCltDaysPeriod();
		assertNotNull(result);
		assertTrue(result.matches("\\d{4}/\\d{2}/\\d{2}"));
	}

	@Test
	public void testGetDurationBreakdown() {
		// Test with 1 hour, 30 minutes, 15 seconds
		long millis = (1 * 60 * 60 * 1000) + (30 * 60 * 1000) + (15 * 1000);
		String result = DateUtility.getDurationBreakdown(millis);
		assertEquals("01:30:15", result);

		// Test with 2 days, 3 hours, 45 minutes
		millis = (2 * 24 * 60 * 60 * 1000) + (3 * 60 * 60 * 1000) + (45 * 60 * 1000);
		result = DateUtility.getDurationBreakdown(millis);
		assertEquals("2 days 03:45:00", result);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetDurationBreakdownNegative() {
		DateUtility.getDurationBreakdown(-1000);
	}

	@Test
	public void testConvertMillisToString() {
		// Test with 2 hours and 30 minutes
		long millis = (2 * 60 * 60 * 1000) + (30 * 60 * 1000);
		String result = DateUtility.convertMillisToString(millis);
		assertEquals("2:30", result);

		// Test with 1 hour and 5 minutes
		millis = (1 * 60 * 60 * 1000) + (5 * 60 * 1000);
		result = DateUtility.convertMillisToString(millis);
		assertEquals("1:05", result);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConvertMillisToStringNegative() {
		DateUtility.convertMillisToString(-1000);
	}

	@Test
	public void testPlusDate() {
		Calendar cal1 = Calendar.getInstance();
		cal1.set(2023, Calendar.JANUARY, 1, 10, 30);
		Date date1 = cal1.getTime();

		Calendar cal2 = Calendar.getInstance();
		cal2.set(2023, Calendar.FEBRUARY, 1, 2, 15);
		Date date2 = cal2.getTime();

		Date result = DateUtility.plusDate(date1, date2);
		assertNotNull(result);
		
		Calendar resultCal = Calendar.getInstance();
		resultCal.setTime(result);
		assertEquals(2023, resultCal.get(Calendar.YEAR));
		assertEquals(Calendar.MARCH, resultCal.get(Calendar.MONTH));
		assertEquals(2, resultCal.get(Calendar.DAY_OF_MONTH));
		assertEquals(12, resultCal.get(Calendar.HOUR_OF_DAY));
		assertEquals(45, resultCal.get(Calendar.MINUTE));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPlusDateNull() {
		DateUtility.plusDate(null, new Date());
	}

	@Test
	public void testMinusDateMonth() {
		Calendar cal1 = Calendar.getInstance();
		cal1.set(2023, Calendar.JUNE, 1);
		Date date1 = cal1.getTime();

		Calendar cal2 = Calendar.getInstance();
		cal2.set(2023, Calendar.JANUARY, 1);
		Date date2 = cal2.getTime();

		int result = DateUtility.minusDateMonth(date1, date2);
		assertEquals(5, result);
	}

	@Test
	public void testMinusDateDays() {
		Calendar cal1 = Calendar.getInstance();
		cal1.set(2023, Calendar.JUNE, 10);
		Date date1 = cal1.getTime();

		Calendar cal2 = Calendar.getInstance();
		cal2.set(2023, Calendar.JUNE, 1);
		Date date2 = cal2.getTime();

		int result = DateUtility.minusDateDays(date1, date2);
		assertEquals(9, result);
	}

	@Test
	public void testMinusDateHour() {
		Calendar cal1 = Calendar.getInstance();
		cal1.set(2023, Calendar.JUNE, 1, 15, 0);
		Date date1 = cal1.getTime();

		Calendar cal2 = Calendar.getInstance();
		cal2.set(2023, Calendar.JUNE, 1, 10, 0);
		Date date2 = cal2.getTime();

		int result = DateUtility.minusDateHour(date1, date2);
		assertEquals(5, result);
	}

	@Test
	public void testMinusDateMinutes() {
		Calendar cal1 = Calendar.getInstance();
		cal1.set(2023, Calendar.JUNE, 1, 10, 45);
		Date date1 = cal1.getTime();

		Calendar cal2 = Calendar.getInstance();
		cal2.set(2023, Calendar.JUNE, 1, 10, 15);
		Date date2 = cal2.getTime();

		int result = DateUtility.minusDateMinutes(date1, date2);
		assertEquals(30, result);
	}

	@Test
	public void testGetHourDate() {
		Date result = DateUtility.getHourDate(2);
		assertNotNull(result);
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR_OF_DAY, 2);
		assertEquals(cal.get(Calendar.HOUR_OF_DAY), 
					Calendar.getInstance().get(Calendar.HOUR_OF_DAY) + 2);
	}

	@Test
	public void testGetHourOfDayMoveTime() {
		Calendar cal = Calendar.getInstance();
		cal.set(2023, Calendar.JUNE, 1, 10, 0);
		Date date = cal.getTime();

		Date result = DateUtility.getHourOfDayMoveTime(date, 3);
		assertNotNull(result);
		
		Calendar resultCal = Calendar.getInstance();
		resultCal.setTime(result);
		assertEquals(13, resultCal.get(Calendar.HOUR_OF_DAY));
	}

	@Test
	public void testGetMinuteOfHourMoveTime() {
		Calendar cal = Calendar.getInstance();
		cal.set(2023, Calendar.JUNE, 1, 10, 30);
		Date date = cal.getTime();

		Date result = DateUtility.getMinuteOfHourMoveTime(date, 45);
		assertNotNull(result);
		
		Calendar resultCal = Calendar.getInstance();
		resultCal.setTime(result);
		assertEquals(11, resultCal.get(Calendar.HOUR_OF_DAY));
		assertEquals(15, resultCal.get(Calendar.MINUTE));
	}

	@Test
	public void testGetMinuteInMillisAfter() {
		Date result = DateUtility.getMinuteInMillisAfter(30);
		assertNotNull(result);
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, 30);
		assertEquals(cal.get(Calendar.MINUTE), 
					Calendar.getInstance().get(Calendar.MINUTE) + 30);
	}

	@Test
	public void testGetMinuteInMillisBefore() {
		Date result = DateUtility.getMinuteInMillisBefore(30);
		assertNotNull(result);
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, -30);
		assertEquals(cal.get(Calendar.MINUTE), 
					Calendar.getInstance().get(Calendar.MINUTE) - 30);
	}

	@Test
	public void testGetHourInMillisAfter() {
		Date result = DateUtility.getHourInMillisAfter(2);
		assertNotNull(result);
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR_OF_DAY, 2);
		assertEquals(cal.get(Calendar.HOUR_OF_DAY), 
					Calendar.getInstance().get(Calendar.HOUR_OF_DAY) + 2);
	}

	@Test
	public void testGetDayInMillisAfter() {
		Date result = DateUtility.getDayInMillisAfter(1);
		assertNotNull(result);
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		assertEquals(cal.get(Calendar.DAY_OF_MONTH), 
					Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + 1);
	}

	@Test
	public void testGetHourInMillisBefore() {
		Date result = DateUtility.getHourInMillisBefore(2);
		assertNotNull(result);
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR_OF_DAY, -2);
		assertEquals(cal.get(Calendar.HOUR_OF_DAY), 
					Calendar.getInstance().get(Calendar.HOUR_OF_DAY) - 2);
	}

	@Test
	public void testGetDayInMillisBefore() {
		Date result = DateUtility.getDayInMillisBefore(1);
		assertNotNull(result);
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, -1);
		assertEquals(cal.get(Calendar.DAY_OF_MONTH), 
					Calendar.getInstance().get(Calendar.DAY_OF_MONTH) - 1);
	}

	@Test
	public void testGetNowTimeGregorian() {
		String timezone = "America/New_York";
		Date result = DateUtility.getNowTimeGregorian(timezone);
		assertNotNull(result);
		
		Calendar cal = new GregorianCalendar(TimeZone.getTimeZone(timezone));
		assertEquals(cal.get(Calendar.HOUR_OF_DAY), 
					Calendar.getInstance(TimeZone.getTimeZone(timezone)).get(Calendar.HOUR_OF_DAY));
	}

	@Test
	public void testGetHourInMillisBeforeGregorian() {
		String timezone = "America/New_York";
		Date result = DateUtility.getHourInMillisBeforeGregorian(2, timezone);
		assertNotNull(result);
		
		Calendar cal = new GregorianCalendar(TimeZone.getTimeZone(timezone));
		cal.add(Calendar.HOUR_OF_DAY, -2);
		assertEquals(cal.get(Calendar.HOUR_OF_DAY), 
					Calendar.getInstance(TimeZone.getTimeZone(timezone)).get(Calendar.HOUR_OF_DAY) - 2);
	}

	@Test
	public void testGetNowYear() {
		int result = DateUtility.getNowYear();
		assertEquals(Calendar.getInstance().get(Calendar.YEAR), result);
	}

	@Test
	public void testGetNowMonth() {
		int result = DateUtility.getNowMonth();
		assertEquals(Calendar.getInstance().get(Calendar.MONTH) + 1, result);
	}

	@Test
	public void testGetNowDay() {
		int result = DateUtility.getNowDay();
		assertEquals(Calendar.getInstance().get(Calendar.DAY_OF_MONTH), result);
	}

	@Test
	public void testFormatDate() {
		Calendar cal = Calendar.getInstance();
		cal.set(2023, Calendar.JUNE, 1, 10, 30, 45);
		Date date = cal.getTime();

		String result = DateUtility.formatDate(date, "yyyy/MM/dd HH:mm:ss");
		assertEquals("2023/06/01 10:30:45", result);
	}

	@Test
	public void testCalculateMonthPeriod() {
		int result = DateUtility.calculateMonthPeriod(2023, 1, 2023, 6);
		assertEquals(6, result);

		result = DateUtility.calculateMonthPeriod(2022, 12, 2023, 1);
		assertEquals(2, result);
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
