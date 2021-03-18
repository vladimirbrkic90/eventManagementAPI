package com.eventmanagementapi.entity;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;

@MappedSuperclass
public class AbstractEntity {

	@Id
	@Column(nullable=false, updatable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long id;
	@CreationTimestamp
	@Column(updatable = false)
	protected Instant created;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Instant getCreated() {
		return created;
	}
	public void setCreated(Instant created) {
		this.created = created;
	}
	
}
