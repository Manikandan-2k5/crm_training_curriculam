package com.learn.java.intro;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


public class DateTimeFunctions {

	public static void main(String[] args) {
		
		//Manipulations with Date and time.
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println("Current date: "+dateTime.toLocalDate());
		System.out.println("Current time: "+dateTime.toLocalTime());
		System.out.println("Month of today: "+dateTime.getMonth());
		System.out.println("Year of today: "+dateTime.getYear());
		System.out.println("Day of the Week for today: "+dateTime.getDayOfWeek());
		System.out.println("Day of the Month for today: "+dateTime.getDayOfMonth());
		System.out.println("Day of the Year for today: "+dateTime.getDayOfYear());
		System.out.println("Date after 1 month: "+dateTime.plusMonths(1).toLocalDate());
		System.out.println("Date before 1 year: "+dateTime.minusYears(1).toLocalDate());
		System.out.println("Date after 1 week: "+dateTime.plusWeeks(1).toLocalDate());
		System.out.println("Time after 1 hour elapsed: "+dateTime.plusHours(1).toLocalTime());
		System.out.println("Time before 1 hour: "+dateTime.minusHours(1).toLocalTime());
		
		//Manipulations with Time Zones.
		ZonedDateTime zonalDateTime = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
		System.out.println("Current time in Asia/Shanghai: "+zonalDateTime.toLocalDateTime());
		
		//Formatting DateTime.
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss ZZZZ");
		String formattedDateTime = zonalDateTime.format(dateTimeFormatter);
		System.out.println("Formatted Date Time of Asia/Shanghai: "+formattedDateTime);
	}
	
}
