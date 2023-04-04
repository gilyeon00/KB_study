package com.jdbc.exception;

public class DuplicatedSSNException extends Exception {
	
	public DuplicatedSSNException() {
		this("This is DuplicatedSSNException");
	}
	
	public DuplicatedSSNException(String message) {
		super(message);
	}
}
