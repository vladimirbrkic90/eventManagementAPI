package com.eventmanagementapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.eventmanagementapi.entity.Event;
import com.eventmanagementapi.repository.EventRepository;

@Service
public class EventService {
	
	@Autowired
	private EventRepository eventRepository;
	
	public Event start(Long id) {
		
		Optional<Event> event = eventRepository.findById(id);
		
		if(!event.isPresent()){
			throw new ResourceNotFoundException("Event with id: " + id + " does not exist!");
		}
		
		event.get().setStarted(true);
		eventRepository.save(event.get());
		
		return event.get();
	}
	
	public void deleteEvent(Long id) {
		
		eventRepository.deleteById(id);
	}
	
	public Event getEvent(Long id) {
		
		Event event = eventRepository.getOne(id);
		
		return event;
	}

}
