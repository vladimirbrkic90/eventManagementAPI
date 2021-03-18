package com.eventmanagementapi.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class Participant extends AbstractEntity {

	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private String email;
	private Boolean checkedIn;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "event_id")
	private Event event;
	
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getCheckedIn() {
		return checkedIn;
	}
	public void setCheckedIn(Boolean checkedIn) {
		this.checkedIn = checkedIn;
	}
	
	@Override
	public boolean equals(Object obj) {
		return Objects.equals(id, ((Participant)obj).id);  
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
