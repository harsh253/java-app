package com.sapient.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Date {
	
	public static final String DATE_FORMAT = "MM/dd/yyyy";
	
	public static LocalDate formatDate(String date) {
		LocalDate ld = null;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
		ld = LocalDate.parse(date, formatter);
		return ld;
	}
	
	public static DateTimeFormatter getDatePattern() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
		return formatter;
	}
	

}
