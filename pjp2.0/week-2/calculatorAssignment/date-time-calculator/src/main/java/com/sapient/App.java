package com.sapient;

import java.util.Scanner;

import com.sapient.Calculator;

public class App {

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		calculator.getMenuItems();
		
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		
		while(true) {
			System.out.println("--------------------");
			System.out.println("Select an option from above (0 to terminate)");
			
			int option = reader.nextInt();
			if(option != 0) {
				calculator.performOperation(option);
			}else {
				return;
			}
		}
	}
}
