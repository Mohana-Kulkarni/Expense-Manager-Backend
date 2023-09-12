package com.example.expensemanager.dao.user;

import com.example.expensemanager.dao.user.UserDAO;
import com.example.expensemanager.entity.User;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

    private EntityManager entityManager;

    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public User findUser(User user) {
        User theUser = entityManager.find(User.class, user);
        if(theUser == null) {
            return null;
        }
        return theUser;
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User deleteUser(User user) {
        User theUser = entityManager.find(User.class, user);
        if(theUser == null) {
            return null;
        }
        entityManager.remove(user);
        return theUser;
    }
}
