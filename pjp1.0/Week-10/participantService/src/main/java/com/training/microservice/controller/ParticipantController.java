package com.training.microservice.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.training.microservice.entity.Participant;
import com.training.microservice.service.ParticipantService;

@RestController
public class ParticipantController {
	
	@Autowired
	public ParticipantService participantService;
	
	@GetMapping("/participants")
	public ArrayList<Participant> getAllParticipants(){
		return participantService.getAllParticipants();
	}
	
	@GetMapping("/participant/{id}")
	public Participant getParticipantById(@PathVariable int id) {
		return participantService.getParticipant(id);		
	}
	
	
	
}
