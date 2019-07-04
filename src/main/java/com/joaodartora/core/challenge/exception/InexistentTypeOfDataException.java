package com.joaodartora.core.challenge.exception;

public class InexistentTypeOfDataException extends Exception{
	private static final long serialVersionUID = 1L;

	public InexistentTypeOfDataException(String errorMessage) {
		super(errorMessage);
	}
	
	public InexistentTypeOfDataException(String errorMessage, Throwable cause) {
		super(errorMessage, cause);
	}
}
