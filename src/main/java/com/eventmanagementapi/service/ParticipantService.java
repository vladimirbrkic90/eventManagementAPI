package com.eventmanagementapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventmanagementapi.entity.Participant;
import com.eventmanagementapi.exceptions.AlreadyCheckedInException;
import com.eventmanagementapi.repository.ParticipantRepository;

@Service
public class ParticipantService {

	@Autowired
	private ParticipantRepository participantRepository;

	public Participant checkIn(Long id) {

		Participant participant = participantRepository.getOne(id);

		if (participant != null) {
			if (participant.getCheckedIn()) {
				throw new AlreadyCheckedInException("Participant is already checked in!");
			}
			participant.setCheckedIn(true);
			participantRepository.save(participant);
		}

		return participant;
	}
}
