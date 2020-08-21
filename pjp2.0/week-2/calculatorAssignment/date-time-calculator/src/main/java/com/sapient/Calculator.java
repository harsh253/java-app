package com.sapient;

import java.time.LocalDate;


import java.util.Scanner;

import com.sapient.Menu;
import com.sapient.Operations;
import com.sapient.Util;

public class Calculator {

	Menu menu;
	Operations operations;

	public Calculator() {
		menu = new Menu();
		operations = new Operations();
	}

	public void getMenuItems() {
		menu.showOptions();
	}

	public void performOperation(int optionNumber) {

		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		LocalDate givenDate;
		LocalDate date1;
		LocalDate date2;
		Integer manipulator;
		switch (optionNumber) {
		case 1:
			System.out.println("Enter date 1 (date month,year)");
			date1 = Util.formatDate(reader.nextLine());
			System.out.println("Enter date 2 (date month,year)");
			date2 = Util.formatDate(reader.nextLine());
			String result = operations.subtractTwoDates(date1, date2);
			System.out.println(result);
			break;

		case 2:
			System.out.println("Enter the date (date month,year)");
			givenDate = Util.formatDate(reader.nextLine());
			System.out.println("How many days you wish to add to your date ?");
			manipulator = reader.nextInt();
			System.out.println(operations.addDaysToDate(givenDate, manipulator));
			break;

		case 3:
			System.out.println("Enter the date (date month,year)");
			givenDate = Util.formatDate(reader.nextLine());
			System.out.println("How many months you wish to add to your date ?");
			manipulator = reader.nextInt();
			System.out.println(operations.addMonthsToDate(givenDate, manipulator));
			break;

		case 4:
			System.out.println("Enter the date (date month,year)");
			givenDate = Util.formatDate(reader.nextLine());
			System.out.println("How many weeks you wish to add to your date ?");
			manipulator = reader.nextInt();
			System.out.println(operations.addWeeksToDate(givenDate, manipulator));
			break;

		case 5:
			System.out.println("Enter the date (date month,year)");
			givenDate = Util.formatDate(reader.nextLine());
			System.out.println(operations.getDayOfWeek(givenDate));
			break;

		case 6:
			System.out.println("Enter the date (date month,year)");
			givenDate = Util.formatDate(reader.nextLine());
			System.out.println(operations.getWeekNumber(givenDate));
			break;

		case 7:
			System.out.println("Enter the date (date month,year)");
			givenDate = Util.formatDate(reader.nextLine());
			System.out.println("How many days you wish to subract from your date ?");
			manipulator = reader.nextInt();
			System.out.println(operations.subtractDaysFromDate(givenDate, manipulator));
			break;

		case 8:
			System.out.println("Enter the date (date month,year)");
			givenDate = Util.formatDate(reader.nextLine());
			System.out.println("How many months you wish to subract from your date ?");
			manipulator = reader.nextInt();
			System.out.println(operations.subtractMonthsFromDate(givenDate, manipulator));
			break;

		case 9:
			System.out.println("Enter the date (date month,year)");
			givenDate = Util.formatDate(reader.nextLine());
			System.out.println("How many weeks you wish to subract from your date ?");
			manipulator = reader.nextInt();
			System.out.println(operations.subtractWeeksFromDate(givenDate, manipulator));
			break;

		case 10:
			System.out.println(operations.getSessionHistory());
			break;
			
		case 11:
			operations.exportHistory();
			break;
			
		default:
			break;
		}
	}

}
