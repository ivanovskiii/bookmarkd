package com.finki.bookmarkd.web.controller;

import com.finki.bookmarkd.model.exceptions.InvalidArgumentException;
import com.finki.bookmarkd.model.exceptions.PasswordDoNotMatchException;
import com.finki.bookmarkd.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getRegisterPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()){
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        return "register";
    }

    @PostMapping
    public String register(@RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String repeatedPassword,
                           @RequestParam String name,
                           @RequestParam String surname){
        try{
            this.userService.register(username, password, repeatedPassword, name, surname);
            return "redirect:/login";
        }
        catch(PasswordDoNotMatchException | InvalidArgumentException exception){
            return "redirect:/register?error=" + exception.getMessage();
        }

    }
}
