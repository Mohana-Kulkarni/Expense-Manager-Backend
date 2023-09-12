package com.example.expensemanager.service.category;

import com.example.expensemanager.dto.CategoryTransactionResponse;
import com.example.expensemanager.entity.Category;
import com.example.expensemanager.entity.Transaction;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    Category getCategoryById(int id);

    void addCategory(Category category);

    void updateCategory(Category category);

    Category deleteCategoryById(int id);

    CategoryTransactionResponse getTransactionsByCategoryId(int id);
}
