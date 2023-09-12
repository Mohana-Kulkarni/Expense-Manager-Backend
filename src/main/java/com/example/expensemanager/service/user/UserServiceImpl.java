package com.example.expensemanager.service.user;

import com.example.expensemanager.dao.user.UserDAO;
import com.example.expensemanager.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User findUser(User user) {
        return userDAO.findUser(user);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    public User deleteUser(User user) {
        return userDAO.deleteUser(user);
    }
}
