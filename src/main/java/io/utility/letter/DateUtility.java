package io.utility.letter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class DateUtility {

	public static int MINUTE_IN_MILLIS = 60000;
	public static int HOUR_IN_MILLIS = 3600000;
	public static int DAY_IN_MILLIS = 86400000;
	public static String DEFAULT_FORMAT_DATE = "yyyy/MM/dd HH:mm:ss";
	public static int DIFF_SECONDS = 1000 % 60;
	public static int DIFF_MINUTES = (60 * 1000) % 60;
	public static int DIFF_HOURS = (60 * 60 * 1000) % 24;
	public static int DIFF_DAYS = (24 * 60 * 60 * 1000);

	 /**
     * Convert a millisecond duration to a string format
     * 
     * @param millis A duration to convert to a string form
     * @return A string of the form "X Days Y Hours Z Minutes A Seconds".
     */
    public static String getDurationBreakdown(long millis) {
        if(millis < 0) {
            throw new IllegalArgumentException("Duration must be greater than zero!");
        }

        long days = TimeUnit.MILLISECONDS.toDays(millis);
        millis -= TimeUnit.DAYS.toMillis(days);
        long hours = TimeUnit.MILLISECONDS.toHours(millis);
        millis -= TimeUnit.HOURS.toMillis(hours);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
        millis -= TimeUnit.MINUTES.toMillis(minutes);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis);

        StringBuilder sb = new StringBuilder(64);
        sb.append(String.format("%02d", hours));
        sb.append(":");
        sb.append(String.format("%02d", minutes));
        sb.append(":");
        sb.append(String.format("%02d", seconds));

        return(sb.toString());
    }

    public static String convertMillisToString(long millisTime) {
    	StringBuffer sb = new StringBuffer();

        long longHour = millisTime / DIFF_HOURS;
        long longMinutes = millisTime / DIFF_MINUTES;
        sb.append(longHour).append(":").append(String.format("%02d", longMinutes));

        return sb.toString();
    }

	public static Date plusDate(Date factor1, Date factor2) {

		long d1 = factor1.getTime();
		long d2 = factor2.getTime();

		long plusedDate = d1 + d2;

		return convertMillisToDate(plusedDate);
	}

	public static Date minusDate(Date factor1, Date factor2) {

		long d1 = factor1.getTime();
		long d2 = factor2.getTime();

		long minusedDate = d1 - d2;

		return convertMillisToDate(minusedDate);
	}

	public static Date convertMillisToDate(long millisTime) {
		Calendar calSevenDay = Calendar.getInstance();
		calSevenDay.setTimeInMillis(millisTime);
		return calSevenDay.getTime();
	}

	public static Date getHourDate(int intNumber) {

		long currentMillis = System.currentTimeMillis();
		Calendar calSevenDay = Calendar.getInstance();
		calSevenDay.setTimeInMillis(currentMillis);
		calSevenDay.add(Calendar.HOUR_OF_DAY, intNumber);

		return calSevenDay.getTime();

	}

	public static Date getHourOfDayMoveTime(Date date, int intMoveTime) {

		Calendar calSevenDay = Calendar.getInstance();
		calSevenDay.setTime(date);
		calSevenDay.add(Calendar.HOUR_OF_DAY, intMoveTime);

		return calSevenDay.getTime();
	}

	public static Date getMinuteOfHourMoveTime(Date date, int intMoveTime) {

		Calendar calSevenDay = Calendar.getInstance();
		calSevenDay.setTime(date);
		calSevenDay.add(Calendar.MINUTE, intMoveTime);

		return calSevenDay.getTime();
	}

	public static Date getMinuteInMillisAfter(int afterMinute) {

		long currentMillis = 0;

		// Set two hour
		currentMillis = System.currentTimeMillis();

		// After seven days of a year, its axis of current time
		long afterSevenMillis = currentMillis + MINUTE_IN_MILLIS * afterMinute;
		Calendar calSevenDay = Calendar.getInstance();
		calSevenDay.setTimeInMillis(afterSevenMillis);
		Date afterSevenDate = calSevenDay.getTime();

		return afterSevenDate;
	}

	public static Date getMinuteInMillisBefore(int beforeMinute) {
	
		long currentMillis = 0;
	
		// Set two hour
		currentMillis = System.currentTimeMillis();
	
		// After seven days of a year, its axis of current time
		long afterSevenMillis = currentMillis - MINUTE_IN_MILLIS * beforeMinute;
		Calendar calSevenDay = Calendar.getInstance();
		calSevenDay.setTimeInMillis(afterSevenMillis);
		Date afterSevenDate = calSevenDay.getTime();
	
		return afterSevenDate;
	}

	public static Date getHourInMillisAfter(int afterDate) {

		long currentMillis = 0;

		// Set two hour
		currentMillis = System.currentTimeMillis();

		// After seven days of a year, its axis of current time
		long afterSevenMillis = currentMillis + HOUR_IN_MILLIS * afterDate;
		Calendar calSevenDay = Calendar.getInstance();
		calSevenDay.setTimeInMillis(afterSevenMillis);
		Date afterSevenDate = calSevenDay.getTime();

		return afterSevenDate;
	}

	public static Date getDayInMillisAfter(int afterDate) {

		long currentMillis = 0;

		// Set two hour
		currentMillis = System.currentTimeMillis();

		// After seven days of a year, its axis of current time
		long afterSevenMillis = currentMillis + DAY_IN_MILLIS * afterDate;
		Calendar calSevenDay = Calendar.getInstance();
		calSevenDay.setTimeInMillis(afterSevenMillis);
		Date afterSevenDate = calSevenDay.getTime();

		return afterSevenDate;
	}

	public static Date getHourInMillisBefore(int beforeHour) {

		long currentMillis = 0;

		// Set two hour
		currentMillis = System.currentTimeMillis();

		// After seven days of a year, its axis of current time
		long afterSevenMillis = currentMillis - HOUR_IN_MILLIS * beforeHour;
		Calendar calSevenDay = Calendar.getInstance();
		calSevenDay.setTimeInMillis(afterSevenMillis);
		Date afterSevenDate = calSevenDay.getTime();

		return afterSevenDate;
	}

	public static Date getDayInMillisBefore(int beforeDay) {

		long currentMillis = 0;

		// Set two hour
		currentMillis = System.currentTimeMillis();

		// After seven days of a year, its axis of current time
		long afterSevenMillis = currentMillis - DAY_IN_MILLIS * beforeDay;

		Calendar calSevenDay = Calendar.getInstance();
		calSevenDay.setTimeInMillis(afterSevenMillis);
		Date afterSevenDate = calSevenDay.getTime();

		return afterSevenDate;
	}

	public static Date getDaySet(int year, int month, int day, int hour, int minute, int second) {

		Calendar calDay = Calendar.getInstance();
		calDay.set(year, month-1, day);
		calDay.set(Calendar.HOUR_OF_DAY, hour);
		calDay.set(Calendar.MINUTE, minute);
		calDay.set(Calendar.SECOND, second);

		return calDay.getTime();
	}

	public static Date getStartToday(int year, int month, int day, int hour) {

		Calendar calDay = Calendar.getInstance();
		calDay.set(year, month-1, day);
		calDay.set(Calendar.HOUR_OF_DAY, hour);
		calDay.set(Calendar.MINUTE, 0);
		calDay.set(Calendar.SECOND, 0);

		return calDay.getTime();
	}

	public static Date getEndToday(int year, int month, int date, int hour) {

		Calendar calDay = Calendar.getInstance();
		calDay.set(year, month-1, date);
		calDay.set(Calendar.HOUR_OF_DAY, hour);
		calDay.set(Calendar.MINUTE, 59);
		calDay.set(Calendar.SECOND, 59);

		return calDay.getTime();
	}

	public static Date getStartToday() {
	
		long currentMillis = 0;
	
		// Set two hour
		currentMillis = System.currentTimeMillis();
	
		Calendar calDay = Calendar.getInstance();
		calDay.setTimeInMillis(currentMillis);
		calDay.set(Calendar.HOUR_OF_DAY, 0);
		calDay.set(Calendar.MINUTE, 0);
		calDay.set(Calendar.SECOND, 0);
	
		return calDay.getTime();
	}

	public static Date getStartDayOfMonth() {
		return getStartDayOfMonth(0);
	}

	public static Date getStartDayOfMonth(int offsetMonth) {

		long currentMillis = 0;

		// Set two hour
		currentMillis = System.currentTimeMillis();

		Calendar calDay = Calendar.getInstance();
		calDay.setTimeInMillis(currentMillis);
		calDay.set(Calendar.MONTH, calDay.get(Calendar.MONTH) + offsetMonth);
		calDay.set(Calendar.DATE, 1);
		calDay.set(Calendar.HOUR_OF_DAY, 0);
		calDay.set(Calendar.MINUTE, 0);
		calDay.set(Calendar.SECOND, 0);

		return calDay.getTime();
	}

	public static Date getEndDayOfMonth(int offsetMonth) {

		long currentMillis = 0;

		// Set two hour
		currentMillis = System.currentTimeMillis();

		Calendar calDay = Calendar.getInstance();
		calDay.setTimeInMillis(currentMillis);
		calDay.set(Calendar.MONTH, calDay.get(Calendar.MONTH) + offsetMonth);
		calDay.set(Calendar.DAY_OF_MONTH, calDay.getActualMaximum(Calendar.DAY_OF_MONTH));
		calDay.set(Calendar.HOUR_OF_DAY, 23);
		calDay.set(Calendar.MINUTE, 59);
		calDay.set(Calendar.SECOND, 59);

		return calDay.getTime();
	}

	public static Date getStartBeforeDay(int beforeDay) {

		long currentMillis = 0;

		// Set two hour
		currentMillis = System.currentTimeMillis();

		// After seven days of a year, its axis of current time
		long afterSevenMillis = currentMillis - DAY_IN_MILLIS * beforeDay;

		Calendar calDay = Calendar.getInstance();
		calDay.setTimeInMillis(afterSevenMillis);
		calDay.set(Calendar.HOUR_OF_DAY, 0);
		calDay.set(Calendar.MINUTE, 0);
		calDay.set(Calendar.SECOND, 0);

		return calDay.getTime();
	}

	public static Date getStartAfterDay(int afterDay) {
	
		long currentMillis = 0;
	
		// Set two hour
		currentMillis = System.currentTimeMillis();
	
		// After seven days of a year, its axis of current time
		long afterSevenMillis = currentMillis + DAY_IN_MILLIS * afterDay;
	
		Calendar calDay = Calendar.getInstance();
		calDay.setTimeInMillis(afterSevenMillis);
		calDay.set(Calendar.HOUR_OF_DAY, 0);
		calDay.set(Calendar.MINUTE, 0);
		calDay.set(Calendar.SECOND, 0);
	
		return calDay.getTime();
	}

	public static Date getEndBeforeDay(int beforeDay) {

		long currentMillis = 0;

		// Set two hour
		currentMillis = System.currentTimeMillis();

		// After seven days of a year, its axis of current time
		long afterSevenMillis = currentMillis - DAY_IN_MILLIS * beforeDay;

		Calendar calDay = Calendar.getInstance();
		calDay.setTimeInMillis(afterSevenMillis);
		calDay.set(Calendar.HOUR_OF_DAY, 23);
		calDay.set(Calendar.MINUTE, 59);
		calDay.set(Calendar.SECOND, 59);

		return calDay.getTime();
	}

	public static Date getEndToday() {

		long currentMillis = 0;

		// Set two hour
		currentMillis = System.currentTimeMillis();

		Calendar calDay = Calendar.getInstance();
		calDay.setTimeInMillis(currentMillis);
		calDay.set(Calendar.HOUR_OF_DAY, 23);
		calDay.set(Calendar.MINUTE, 59);
		calDay.set(Calendar.SECOND, 59);

		return calDay.getTime();
	}

	public static Date getNowTime() {
		long currentMillis = 0;

		// Set two hour
		currentMillis = System.currentTimeMillis();
		Calendar calDay = Calendar.getInstance();
		calDay.setTimeInMillis(currentMillis);

		return calDay.getTime();
	}

	public static Date getNowTimeGregorian(String timezone) {
		Calendar calDay = new GregorianCalendar();
		TimeZone timeZone = TimeZone.getTimeZone(timezone);
		calDay.setTimeZone(timeZone);
		return calDay.getTime();
	}

	public static Date getHourInMillisBeforeGregorian(int beforeHour, String zonename) {

		Calendar calDay = new GregorianCalendar();
		TimeZone timeZone = TimeZone.getTimeZone(zonename);
		calDay.setTimeZone(timeZone);

		// After seven days of a year, its axis of current time
		long afterSevenMillis = calDay.getTimeInMillis() - HOUR_IN_MILLIS * beforeHour;
		Calendar calSevenDay = new GregorianCalendar();
		calSevenDay.setTimeInMillis(afterSevenMillis);
		Date afterSevenDate = calSevenDay.getTime();

		return afterSevenDate;
	}

	public static int getNowYear() {
		Calendar calDay = Calendar.getInstance();
		return calDay.get(Calendar.YEAR);
	}

	public static int getNowYear(long timeMillis) {
		Calendar calDay = Calendar.getInstance();
		calDay.setTimeInMillis(timeMillis);
		return calDay.get(Calendar.YEAR);
	}

	public static int getNowMonth() {
		Calendar calDay = Calendar.getInstance();
		return calDay.get(Calendar.MONTH) + 1;
	}

	public static int getNowMonth(int offset) {
		Calendar calDay = Calendar.getInstance();
		return calDay.get(Calendar.MONTH) + 1 + offset;
	}

	public static int getNowDay() {
		Calendar calDay = Calendar.getInstance();
		return calDay.get(Calendar.DATE);
	}

	public static String formatDate(Date date, String format) {
		SimpleDateFormat sdf = null;
		if(format == null) {
			sdf = new SimpleDateFormat(DEFAULT_FORMAT_DATE);
		} else {
			sdf = new SimpleDateFormat(format);
		}
		return sdf.format(date);
	}

	/**
	 * 
	 * @param intStartYear
	 * @param intStartMonth
	 * @param intEndYear
	 * @param intEndMonth
	 * @return
	 */
	public static int calculateMonthPeriod(int intStartYear, int intStartMonth, 
			int intEndYear, int intEndMonth) {

		int intIntervalYear = intEndYear - intStartYear;
		int intIntervalMonth = intEndMonth - intStartMonth;
		// calculate year and month + 1
		int intIntervalTime = intIntervalYear * 12 + intIntervalMonth + 1;

		return intIntervalTime;
	}

}