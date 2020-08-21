package com.tutorial.Spring;

public class Mobile {
	
	private Screen screen;
	private Camera camera;
	private Speaker speaker;
	
	public Mobile() {
		System.out.println("Mobile object created");
	}
	
	public void setScreen(Screen screen) {
		this.screen = screen;
	}
	
	public void setCamera(Camera camera) {
		this.camera = camera;
	}
	
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	
	public void display() {
		System.out.println("Mobile being generated");
		screen.showScreen();
		camera.showCamera();
		speaker.showSpeaker();
	}

	
	
	
	
	

}
