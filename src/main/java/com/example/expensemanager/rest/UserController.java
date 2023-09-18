package com.example.expensemanager.rest;

import com.example.expensemanager.dao.user.UserDetailsImpl;
import com.example.expensemanager.entity.User;
import com.example.expensemanager.service.user.UserDetailsServiceImpl;
import com.example.expensemanager.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
//@EnableMethodSecurity
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserDetailsService userDetailsService;
    @GetMapping("/{userId}")
    public User getUserById(@PathVariable int userId) {
        return userService.getUserById(userId);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/test")
    public Authentication getAuthenticatedUser(){

        return SecurityContextHolder.getContext().getAuthentication();
    }
    @PostMapping("/")
    public void addUser(@RequestBody User user){
        System.out.println(user);
        userService.saveUser(user);
    }

//    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/authenticateUser")
    public String authenticateUser(@RequestBody User user) {
        return userService.authenticateUser(user);
    }

}
