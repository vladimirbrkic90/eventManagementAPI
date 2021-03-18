package com.eventmanagementapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventmanagementapi.entity.Venue;

public interface VenueRepository extends JpaRepository<Venue, Long> {

}
