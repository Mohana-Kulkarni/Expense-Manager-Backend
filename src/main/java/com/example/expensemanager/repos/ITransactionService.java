package com.example.expensemanager.repos;

import com.example.expensemanager.entity.Transaction;

import java.util.List;

public interface ITransactionService {
    List<Transaction> findAll();
}
