package com.thehutgroup.accelerator.marcus.day11;

public class DataOutOfBoundsException extends Exception {
    private static final String ERROR_MESSAGE = "This is an index exception: %s";
    public DataOutOfBoundsException(String value){
        super(ERROR_MESSAGE.formatted(value));
    }
}
