package com.sapient;

import java.util.ArrayList;

import com.sapient.Option;

public class Menu {
	
	private ArrayList<Option> optionsList = new ArrayList<>();

	public Menu() {
		this.initializeOptions();
	}
	
	public void addOptionToMenu(String option) {
		optionsList.add(new Option(option));
	}
	
	
	public void showOptions() {
		for(int i=0; i<optionsList.size(); i++) {
			System.out.println((i+1) + ". " + optionsList.get(i).getOptionName());
		}
	}
	
	public void initializeOptions() {
		this.addOptionToMenu("Subtract two dates");
		this.addOptionToMenu("Add n days to given date");
		this.addOptionToMenu("Add n months to given date");
		this.addOptionToMenu("Add n weeks to given date");
		this.addOptionToMenu("Get day of week for a given date");
		this.addOptionToMenu("Get week number for a given date");
		this.addOptionToMenu("Subtract n days from given date");
		this.addOptionToMenu("Subtract n months from given date");
		this.addOptionToMenu("Subtract n weeks from given date");
		this.addOptionToMenu("Show history of calculations");
		this.addOptionToMenu("Export history");
	}
}
