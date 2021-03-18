package com.eventmanagementapi.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.eventmanagementapi.entity.Event;
import com.eventmanagementapi.entity.projections.PartialEventProjection;

@RepositoryRestResource(excerptProjection = PartialEventProjection.class)
public interface EventRepository extends JpaRepository<Event, Long> {

	Page<Event> findByName(String name, Pageable p);

}
