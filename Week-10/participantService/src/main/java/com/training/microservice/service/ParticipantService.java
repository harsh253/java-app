package com.training.microservice.service;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.training.microservice.entity.Participant;

@Component
public class ParticipantService {
	public static ArrayList<Participant> participants = new ArrayList<>();
	
	static {
		participants.add(new Participant(1, "Naveen", 1));
		participants.add(new Participant(2, "Sangeetha", 2));
		participants.add(new Participant(3, "Mukesh", 1));
		participants.add(new Participant(4, "Ayush", 4));
		participants.add(new Participant(5, "Shashank", 4));
	}
	
	public ArrayList<Participant> getAllParticipants(){
		return participants;
	}
	
	public Participant getParticipant(int id) {
		for(Participant p: participants) {
			if(p.getpId() == id) {
				return p;
			}
		}
		return null;
	}
	
	public ArrayList<Participant> getParticipantsOfMeeting(int id){
		ArrayList<Participant> members = new ArrayList<>();
		for(Participant p: participants) {
			if(p.getMeetingId()==id) {
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
