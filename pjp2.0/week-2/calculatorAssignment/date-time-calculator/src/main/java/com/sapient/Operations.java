package com.sapient;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;

public class Operations {
	
	private Queue<String> sessionHistory;
	private static final int MAX_HISTORY_SIZE = 100;
	
	public Operations() {
		sessionHistory = new LinkedList<>();
	}
	
	
	public String subtractTwoDates(LocalDate date1, LocalDate date2) {
		Period p = Period.between(date1, date2);
		long totalDays = ChronoUnit.DAYS.between(date1, date2);
		long totalMonths = ChronoUnit.MONTHS.between(date1, date2);
		long totalWeeks = ChronoUnit.WEEKS.between(date1, date2);
		String result = p.getYears() + " years, " + totalMonths + " months, " + totalDays + " days, " + totalWeeks + " weeks";
		this.addToHistory("Subtract Two Dates", date1, date2, result);
		return result;
	}
	
	public LocalDate addDaysToDate(LocalDate date, int daysToAdd) {
		LocalDate newDate = date.plusDays(daysToAdd);
		this.addToHistory("Add n days", date, daysToAdd, newDate.toString());
		return newDate;
	}
	
	public LocalDate addMonthsToDate(LocalDate date, Integer monthsToAdd) {
		LocalDate newDate = date.plusMonths(monthsToAdd);
		this.addToHistory("Add n months", date, monthsToAdd, newDate.toString());
		return newDate;
	}
	
	public LocalDate addWeeksToDate(LocalDate date, Integer weeksToAdd) {
		LocalDate newDate = date.plusWeeks(weeksToAdd);
		this.addToHistory("Add n weeks", date, weeksToAdd, newDate.toString());
		return newDate;
	}
	
	public LocalDate subtractDaysFromDate(LocalDate date, Integer daysToSubtract) {
		LocalDate newDate = date.minusDays(daysToSubtract);
		this.addToHistory("Subtract n days", date, daysToSubtract, newDate.toString());
		return newDate;
	}
	
	public LocalDate subtractMonthsFromDate(LocalDate date, Integer monthsToSubtract) {
		LocalDate newDate = date.minusMonths(monthsToSubtract);
		this.addToHistory("Subtract n months", date, monthsToSubtract, newDate.toString());
		return newDate;
	}
	
	public LocalDate subtractWeeksFromDate(LocalDate date, Integer weeksToSubtract) {
		LocalDate newDate = date.minusWeeks(weeksToSubtract);
		this.addToHistory("Subtract n weeks", date, weeksToSubtract, newDate.toString());
		return newDate;
	}
	
	public DayOfWeek getDayOfWeek(LocalDate date) {
		DayOfWeek day = date.getDayOfWeek();
		this.addToHistory("Get Day of Week", date, day.toString());
		return day;
	}
	
	public int getWeekNumber(LocalDate date) {
		TemporalField week = WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear();
		this.addToHistory("Get Week Number", date, ((Integer)date.get(week)).toString());
		return date.get(week);
	}
	
	public String getSessionHistory() {
		String output = "";
		output+=(this.sessionHistory)+"\n";
		return output;
	}
	
	public void exportHistory() {
		Util.exportSessionHistory(this.sessionHistory);
	}
	
	
	private void addToHistory(String operation, LocalDate date1, LocalDate date2, String result) {
		History history = new History();
		history.addDate(date1);
		history.addDate(date2);
		history.setOperationName(operation);
		history.setResult(result);
		this.sessionHistory = Util.restrictQueueSize(sessionHistory, MAX_HISTORY_SIZE);
		this.sessionHistory.add(history.getHistory());
	}
	
	private void addToHistory(String operation, LocalDate date, Integer manipulator, String result) {
		History history = new History();
		history.addDate(date);
		history.setManipulator(manipulator);
		history.setOperationName(operation);
		history.setResult(result);
		this.sessionHistory = Util.restrictQueueSize(sessionHistory, MAX_HISTORY_SIZE);
		this.sessionHistory.add(history.getHistory());
		
	}
	
	private void addToHistory(String operation, LocalDate date, String result) {
		History history = new History();
		history.addDate(date);
		history.setOperationName(operation);
		history.setResult(result);
		this.sessionHistory = Util.restrictQueueSize(sessionHistory, MAX_HISTORY_SIZE);
		this.sessionHistory.add(history.getHistory());
	}
	
	

}