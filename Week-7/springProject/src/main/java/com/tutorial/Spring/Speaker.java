package com.tutorial.Spring;

public class Speaker {
	private int volLevel;
	private String type;

	public int getVolLevel() {
		return volLevel;
	}

	public void setVolLevel(int volLevel) {
		this.volLevel = volLevel;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public void showSpeaker() {
		System.out.println("Speaker Generated");
	}

}
