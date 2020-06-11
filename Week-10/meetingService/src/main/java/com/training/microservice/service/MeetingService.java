package com.training.microservice.service;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.training.microservice.entity.Meeting;

@Component
public class MeetingService {
	public static ArrayList<Meeting> meetings = new ArrayList<>();
	
	static {
		meetings.add(new Meeting(1, "Corona", "11:00", "13:00"));
		meetings.add(new Meeting(2, "REST", "14:00", "16:00"));
		meetings.add(new Meeting(3, "Microservices", "08:00", "10:00"));
		meetings.add(new Meeting(4, "Node", "16:00", "17:00"));
		meetings.add(new Meeting(5, "Java", "18:00", "19:00"));
	}
	
	public ArrayList<Meeting> getAllMeetings(){
		return meetings;
	}
	
	public Meeting getMeeting(int id) {
		for(Meeting m:meetings) {
			if(m.getMeetingId() == id) {
				return m;
			}
		}
		return null;
	}
}
