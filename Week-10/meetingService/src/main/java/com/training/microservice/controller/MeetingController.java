package com.training.microservice.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.training.microservice.entity.Meeting;
import com.training.microservice.entity.Participant;
import com.training.microservice.service.MeetingService;

@RestController
public class MeetingController {
	
	@Autowired
	public MeetingService meetingService;
	
	RestTemplate restTemplate = new RestTemplate(); 
	
	@GetMapping("/meeting")
	public ArrayList<Meeting> getAllMeetings(){
		return meetingService.getAllMeetings();
	}
	
	@GetMapping("/meeting/{id}")
	public Meeting getMeetingById(@PathVariable int id) {
		return meetingService.getMeeting(id);
	}
	
	@GetMapping("/{meetingId}/participants")
	public ArrayList<Participant> getParticipantsOfAMeeting(@PathVariable int meetingId){
		ResponseEntity<Participant[]> participants = restTemplate.getForEntity("http://localhost:8082/participants", Participant[].class);
		ArrayList<Participant> members = new ArrayList<>();
		for(Participant p: participants.getBody()) {
			if(p.getMeetingId() == meetingId) {
				members.add(p);
			}
		}
		if(members.size()>0) {
			return members;
		}else {
			return null;
		}
	}
}
