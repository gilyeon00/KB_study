package com.jdbc.exception;

public class DuplicatedIDException extends Exception {
	
	public DuplicatedIDException() {
		this("This is DuplicatedSSNException");
	}
	
	public DuplicatedIDException(String message) {
		super(message);
	}
}
