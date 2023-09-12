package com.example.expensemanager.rest;

import com.example.expensemanager.entity.User;
import com.example.expensemanager.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/")
    public void addUser(@RequestBody User user){
        userService.saveUser(user);
    }

    @PostMapping("/authenticateUser")
    public String authenticateUser(@RequestBody User user) {
        return userService.authenticateUser(user);
    }
}
