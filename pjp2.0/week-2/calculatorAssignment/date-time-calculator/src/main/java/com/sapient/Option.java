package com.sapient;

public class Option {
	
	private String name;
	
	public Option() {
		
	}
	
	public Option(String name) {
		if(name == null || name.length() == 0) {
			throw new IllegalArgumentException();
		}
		this.name = name;
	}
	
	public String getOptionName() {
		return name;
	}
	
	public void setOptionName(String name) {
		this.name = name;
	}
	
	
	
	
}