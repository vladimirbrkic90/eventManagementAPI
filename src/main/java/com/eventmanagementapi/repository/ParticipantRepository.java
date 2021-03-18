package com.eventmanagementapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventmanagementapi.entity.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {

}
