package com.eventmanagementapi.entity.projections;

import java.time.ZonedDateTime;

import org.springframework.data.rest.core.config.Projection;

import com.eventmanagementapi.entity.Event;

@Projection(name = "partialEvent", types = { Event.class })
public interface PartialEventProjection {

	String getName();

	ZonedDateTime getStartTime();

	ZonedDateTime getEndTime();

}
