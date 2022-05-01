package com.finki.bookmarkd.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
public class ProductAlreadyInCartException extends RuntimeException{
    public ProductAlreadyInCartException(Long id, String username) {
        super(String.format("Product with id: %d for username: %s already in cart!", id, username));
    }
}
