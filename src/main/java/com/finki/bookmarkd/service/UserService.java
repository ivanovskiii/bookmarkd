package com.finki.bookmarkd.service;

import com.finki.bookmarkd.model.User;

public interface UserService {
    User login(String username, String password);
    User register(String username, String password, String repeatedPassword, String name, String surname);
}
