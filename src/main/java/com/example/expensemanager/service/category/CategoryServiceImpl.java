package com.example.expensemanager.service.category;

import com.example.expensemanager.dao.category.CategoryDAO;
import com.example.expensemanager.dto.CategoryTransactionResponse;
import com.example.expensemanager.entity.Category;
import com.example.expensemanager.entity.Transaction;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    private CategoryDAO categoryDAO;

    public CategoryServiceImpl(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryDAO.findAllCategories();
    }

    @Override
    public Category getCategoryById(int id) {
        return categoryDAO.findCategoryById(id);
    }

    @Override
    @Transactional
    public void addCategory(Category category) {
        categoryDAO.addCategory(category);
    }

    @Override
    @Transactional
    public void updateCategory(Category category) {
        categoryDAO.updateCategory(category);
    }

    @Override
    @Transactional
    public Category deleteCategoryById(int id) {
        return categoryDAO.deleteCategoryById(id);
    }

    @Override
    public CategoryTransactionResponse getTransactionsByCategoryId(int id) {
        Category category = categoryDAO.findCategoryById(id);
        List<Transaction> transactionList = category.getTransactions();
        return new CategoryTransactionResponse(category, transactionList);
    }
}
