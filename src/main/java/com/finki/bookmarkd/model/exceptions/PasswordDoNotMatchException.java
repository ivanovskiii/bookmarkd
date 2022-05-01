package com.finki.bookmarkd.model.exceptions;

public class PasswordDoNotMatchException extends RuntimeException{
    public PasswordDoNotMatchException() {
        super("Passwords do not match exception");
    }
}
