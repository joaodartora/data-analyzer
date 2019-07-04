package com.joaodartora.core.temafinal.exception;

public class InexistentTypeOfDataException extends Exception{
	private static final long serialVersionUID = 1L;

	public InexistentTypeOfDataException(String errorMessage) {
		super(errorMessage);
	}
	
	public InexistentTypeOfDataException(String errorMessage, Throwable cause) {
		super(errorMessage, cause);
	}
}
