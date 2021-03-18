package com.eventmanagementapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventmanagementapi.entity.Organizer;

public interface OrganizerRepository extends JpaRepository<Organizer, Long> {

}
