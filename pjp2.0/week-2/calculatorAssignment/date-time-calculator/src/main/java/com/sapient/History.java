package com.sapient;

import java.time.LocalDate;
import java.util.ArrayList;


public class History {
		
	private ArrayList<LocalDate> dates;
	private String operationName;
	private String result;
	private Integer manipulator;
	
	public History() {
		this.dates = new ArrayList<>();
	}
	
	public String getOperationName() {
		return operationName;
	}

	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Integer getManipulator() {
		return manipulator;
	}

	public void setManipulator(Integer manipulator) {
		this.manipulator = manipulator;
	}
	
	public void addDate(LocalDate date) {
		this.dates.add(date);
	}
		
	public String getHistory() {
		String output = "";
		output+="Operation: " + this.operationName + "\n" + "Date(s): ";
		for(LocalDate date: this.dates) {
			output+= date + " ";
		}
		output+="\n";
		if(this.manipulator != null) {
			output+="Manipulated by: " + this.manipulator + "\n";
		}
		output+="Result: " + this.result + "\n";
		return output;
	}
	

	

}
