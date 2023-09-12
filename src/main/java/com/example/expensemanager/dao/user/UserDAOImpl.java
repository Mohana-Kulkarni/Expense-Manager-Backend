package com.example.expensemanager.dao.user;

import com.example.expensemanager.dao.user.UserDAO;
import com.example.expensemanager.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

    private EntityManager entityManager;

    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public User findUser(User user) {
        String username = user.getEmail();
        TypedQuery<User> query = entityManager.createQuery("select u from User u " +
                "where u.email = :email", User.class);
        query.setParameter("email" , username);
        User theUser = query.getSingleResult();
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        if(theUser != null) {
            if(bcrypt.matches(user.getPassword(), theUser.getPassword())) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void saveUser(User user) {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        String encryptedPwd = bcrypt.encode(user.getPassword());
        user.setPassword(encryptedPwd);
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
