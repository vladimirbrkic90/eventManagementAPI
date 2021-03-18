package com.eventmanagementapi.exceptions;

public class AlreadyCheckedInException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public AlreadyCheckedInException() {
		
	}

	public AlreadyCheckedInException(String message) {
		super(message);
	}
}
