package com.joaodartora.dataanalyzer.exception;

public class InvalidFileExtensionException extends RuntimeException {

    public InvalidFileExtensionException(String fileName) {
        super("The file" + fileName + "don't have a valid file extension");
    }

}
