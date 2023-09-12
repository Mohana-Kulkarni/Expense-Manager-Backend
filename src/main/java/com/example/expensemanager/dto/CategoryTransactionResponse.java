package com.example.expensemanager.dto;

import com.example.expensemanager.entity.Category;
import com.example.expensemanager.entity.Transaction;

import java.util.List;

public class CategoryTransactionResponse {

    private Category category;
    private List<Transaction> transaction;

    public CategoryTransactionResponse() {

    }
    public CategoryTransactionResponse(Category category, List<Transaction> transaction) {
        this.category = category;
        this.transaction = transaction;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Transaction> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<Transaction> transaction) {
        this.transaction = transaction;
    }

    @Override
    public String toString() {
        return "CategoryTransactionResponse{" +
                "category=" + category +
                ", transaction=" + transaction +
                '}';
    }
}
