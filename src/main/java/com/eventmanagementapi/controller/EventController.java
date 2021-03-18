package com.eventmanagementapi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.eventmanagementapi.entity.Event;
import com.eventmanagementapi.service.EventService;

@RestController
@RequestMapping("/events")
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	@PostMapping("/start/{id}")
	public ResponseEntity<String> start(@PathVariable Long id) {
		
		Event event = eventService.start(id);
		
		return ResponseEntity.ok(event.getName() + " has started!");
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void deleteEvent(@PathVariable Long id) {
		
		eventService.deleteEvent(id);
		
	}

}
