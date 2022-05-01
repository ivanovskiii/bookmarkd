package com.finki.bookmarkd.model.exceptions;

public class InvalidUserCredentialsException extends RuntimeException{

    public InvalidUserCredentialsException() {
        super("Invalid User Credential Exception");
    }
}
