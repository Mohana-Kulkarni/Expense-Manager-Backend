package com.example.expensemanager.service.user;

import com.example.expensemanager.dao.user.UserDAO;
import com.example.expensemanager.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public String authenticateUser(User user) {
        User theUser =  userDAO.findUser(user);
        if(theUser == null) {
            return "Invalid Credentials";
        }
        return "Valid User";
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

    @Override
    public User getUserById(int id) {
        return userDAO.getUser(id);
    }

//    @Override
//    public User authenticateUser(User user) {
//
//        User opUser = userDAO.findUser(user.getId());
//        if(user == null) {
//            return null;
//        }
//
//    }
}
