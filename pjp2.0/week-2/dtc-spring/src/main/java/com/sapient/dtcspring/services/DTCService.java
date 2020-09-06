package com.sapient.dtcspring.services;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;

@Service
public class DTCService {
	
	public String subtractTwoDates(LocalDate date1, LocalDate date2) {
		Period p = Period.between(date1, date2);
		long totalDays = ChronoUnit.DAYS.between(date1, date2);
		long totalMonths = ChronoUnit.MONTHS.between(date1, date2);
		long totalWeeks = ChronoUnit.WEEKS.between(date1, date2);
		String result = p.getYears() + " years, " + totalMonths + " months, " + totalDays + " days, " + totalWeeks + " weeks";
		return result;
	}
	
	public LocalDate addDaysToDate(LocalDate date, int daysToAdd) {
		LocalDate newDate = date.plusDays(daysToAdd);
		return newDate;
	}
	
	public LocalDate subtractMonthsFromDate(LocalDate date, Integer monthsToSubtract) {
		LocalDate newDate = date.minusMonths(monthsToSubtract);
		return newDate;
	}
	
	public DayOfWeek getDayOfWeek(LocalDate date) {
		DayOfWeek day = date.getDayOfWeek();
		return day;
	}

}
