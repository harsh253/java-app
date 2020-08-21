package com.sapient;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Queue;
import java.util.Scanner;

public class Util {
	
	public static final String DATE_FORMAT = "d MMMM,yyyy";
	private static final String FILE_EXTENSION = "txt";
	
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
	
	public static void exportSessionHistory(Queue<String> sessionHistory) {
		String contentToWrite = sessionHistory.toString();
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		BufferedWriter writer = null;
		String filepath;
		String filename = "CalculationsHistory";
		System.out.println("Enter path to file where to export the history");
		filepath = reader.nextLine();
		String fileExtension = FILE_EXTENSION;
		
		filepath = filepath+"/"+filename+ "."+fileExtension;
		try {
			 writer = new BufferedWriter(new FileWriter(filepath));
			writer.write(contentToWrite);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Queue<String> restrictQueueSize(Queue<String> sessionHistory, int maxSize) {
		int lengthOfHistory = sessionHistory.size();
		if(lengthOfHistory >= maxSize) {
			sessionHistory.remove();
		}
		return sessionHistory;
	}
}