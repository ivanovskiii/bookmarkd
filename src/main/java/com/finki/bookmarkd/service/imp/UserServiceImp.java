package com.finki.bookmarkd.service.imp;

import com.finki.bookmarkd.model.User;
import com.finki.bookmarkd.model.exceptions.InvalidArgumentException;
import com.finki.bookmarkd.model.exceptions.InvalidUserCredentialsException;
import com.finki.bookmarkd.model.exceptions.PasswordDoNotMatchException;
import com.finki.bookmarkd.model.exceptions.UsernameExistsException;
import com.finki.bookmarkd.repository.UserRepository;
import com.finki.bookmarkd.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImp(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User login(String username, String password) {
        if(username==null || username.isEmpty() || password == null || password.isEmpty()){
            throw new InvalidArgumentException();
        }
        return userRepository.findByUsernameAndPassword(username, password).orElseThrow(InvalidUserCredentialsException::new);
    }

    @Override
    public User register(String username, String password, String repeatPassword, String name, String surname) {
        if(username==null || username.isEmpty() || password == null || password.isEmpty()){
            throw new InvalidArgumentException();
        }

        if(!password.equals(repeatPassword)){
            throw new PasswordDoNotMatchException();
        }

        if(this.userRepository.findByUsername(username).isPresent() || !this.userRepository.findByUsername(username).isEmpty()){
            throw new UsernameExistsException(username);
        }
        String encryptedPassword = this.passwordEncoder.encode(password);
        User user = new User(username, password, name, surname);
        return this.userRepository.save(user);
    }
}
