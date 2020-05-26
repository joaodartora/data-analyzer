package com.joaodartora.dataanalyzer.exception;

public class InvalidParseTypeException extends RuntimeException {

    private final static String EXCEPTION_MESSAGE = "There is no parse for this type of data";

    public InvalidParseTypeException() {
        super(EXCEPTION_MESSAGE);
    }
}
