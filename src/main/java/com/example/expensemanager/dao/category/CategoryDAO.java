package com.example.expensemanager.dao.category;

import com.example.expensemanager.entity.Category;
import com.example.expensemanager.entity.Transaction;

import java.util.List;

public interface CategoryDAO {

    List<Category> findAllCategories();

    Category findCategoryById(int id);

    void addCategory(Category category);

    void updateCategory(Category category);

    Category deleteCategoryById(int id);

    Category getTransactionsByCategoryId(int id);
}
