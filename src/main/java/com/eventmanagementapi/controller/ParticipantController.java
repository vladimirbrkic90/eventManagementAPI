package com.eventmanagementapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.eventmanagementapi.entity.Participant;
import com.eventmanagementapi.exceptions.AlreadyCheckedInException;
import com.eventmanagementapi.service.ParticipantService;

@RestController
@RequestMapping("/participants")
public class ParticipantController {

	@Autowired
	private ParticipantService participantService;

	@PostMapping("/checkin/{id}")
	public ResponseEntity<String> checkIn(@PathVariable Long id) throws AlreadyCheckedInException {

		Participant participant = participantService.checkIn(id);

		return ResponseEntity.ok(participant.getName() + "is checked in!");
	}

	@ExceptionHandler(AlreadyCheckedInException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public String checkedInError(AlreadyCheckedInException ex) {

		return ex.getMessage();
	}

}
