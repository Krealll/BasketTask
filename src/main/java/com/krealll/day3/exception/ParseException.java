package com.krealll.day3.exception;

public class ParseException extends Exception{

    public ParseException(){}

    public ParseException(String message) {
        super((message));
    }

    public ParseException(Throwable reason) {
        super((reason));
    }

    public ParseException(String message, Throwable reason) {
        super(message, reason);
    }
}
