package com.example.expensemanager.dao.type;

import com.example.expensemanager.entity.Category;
import com.example.expensemanager.entity.Transaction;
import com.example.expensemanager.entity.Type;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TypeDAOImpl implements TypeDAO{

    private EntityManager entityManager;

    public TypeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Type getTypeById(int id) {
        Type type = entityManager.find(Type.class, id);
        if(type == null) {
            return null;
        }
        return type;
    }

    @Override
    public Type getTransactionsByTypeId(int id) {
        Type type = entityManager.find(Type.class, id);
        if(type == null) {
            return null;
        }
        TypedQuery<Type> query = entityManager.createQuery("select t from Type t " +
                "JOIN FETCH t.transactions " +
                "where t.id = :data", Type.class);
        query.setParameter("data", id);
        return query.getSingleResult();
    }
}
