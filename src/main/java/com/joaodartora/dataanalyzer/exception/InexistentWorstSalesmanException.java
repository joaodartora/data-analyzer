package com.joaodartora.dataanalyzer.exception;

public class InexistentWorstSalesmanException extends RuntimeException {

    private final static String EXCEPTION_MESSAGE = "There is no worst salesman ever";

    public InexistentWorstSalesmanException() {
        super(EXCEPTION_MESSAGE);
    }
}
