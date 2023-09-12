package com.example.expensemanager.dao.category;

import com.example.expensemanager.entity.Category;
import com.example.expensemanager.entity.Transaction;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDAOImpl implements CategoryDAO{

    private EntityManager entityManager;

    public CategoryDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public List<Category> findAllCategories() {
        TypedQuery<Category> query = entityManager.createQuery("from Category", Category.class);
        return query.getResultList();
    }

    @Override
    public Category findCategoryById(int id) {
        Category category = entityManager.find(Category.class, id);
        if(category == null) {
            return null;
        }
        return category;
    }

    @Override
    public void addCategory(Category category) {
        entityManager.persist(category);
    }

    @Override
    public void updateCategory(Category category) {

        entityManager.merge(category);
    }

    @Override
    public Category deleteCategoryById(int id) {
        Category category = entityManager.find(Category.class, id);
        if(category == null) {
            return null;
        }
        entityManager.remove(category);
        return category;
    }

    @Override
    public Category getTransactionsByCategoryId(int id) {
        Category category = entityManager.find(Category.class, id);
        if(category == null) {
            return null;
        }
        TypedQuery<Category> query = entityManager.createQuery("select c from Category c " +
                "JOIN FETCH c.transactions " +
                "where c.id = :data", Category.class);
        query.setParameter("data", id);
        return query.getSingleResult();
    }
}
