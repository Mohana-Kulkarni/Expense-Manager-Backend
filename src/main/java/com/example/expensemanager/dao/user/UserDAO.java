package com.example.expensemanager.dao.user;

import com.example.expensemanager.entity.User;

public interface UserDAO {

    User findUser(User user);
    void saveUser(User user);
    void updateUser(User user);

    User deleteUser(User user);


}
