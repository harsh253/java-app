package com.sapient.dtc.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class Date {
	
	public static final String DATE_FORMAT = "yyyy-d-mm";
	
	public static LocalDate formatDate(String date) {
		LocalDate ld = null;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
		for(Locale locale: Locale.getAvailableLocales()) {
			try {
				formatter = formatter.withLocale(locale);
				ld = LocalDate.parse(date, formatter);
				break;
			} catch (DateTimeParseException e) {
				
			}
		}
		return ld;
	}

}
