package com.example.expensemanager.service.user;

import com.example.expensemanager.entity.User;

public interface UserService {

    String authenticateUser(User user);
    void saveUser(User user);
    void updateUser(User user);

    User deleteUser(User user);

//    User authenticateUser(User user);
}
