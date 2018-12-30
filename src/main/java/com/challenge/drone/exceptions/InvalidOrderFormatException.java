package com.challenge.drone.exceptions;

public class InvalidOrderFormatException extends Exception{

    public InvalidOrderFormatException() {
        super();
    }

    public InvalidOrderFormatException(String message) {
        super(message);
    }

}
