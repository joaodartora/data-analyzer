package com.joaodartora.dataanalyzer.exception;

public class InexistentMostExpensiveSaleIdException extends RuntimeException {

    private final static String EXCEPTION_MESSAGE = "There is no most expensive sale id";

    public InexistentMostExpensiveSaleIdException() {
        super(EXCEPTION_MESSAGE);
    }
}
