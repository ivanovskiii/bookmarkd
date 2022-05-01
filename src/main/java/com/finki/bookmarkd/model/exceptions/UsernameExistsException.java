package com.finki.bookmarkd.model.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus()
public class UsernameExistsException extends RuntimeException{
    public UsernameExistsException(String username) {
        super(String.format("User with username: %d already exists!", username));
    }
}
