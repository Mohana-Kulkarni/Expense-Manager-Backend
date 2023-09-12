package com.example.expensemanager.service.transaction;

import com.example.expensemanager.entity.Transaction;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface TransactionService {

    List<Transaction> findAllTransactions();

    Transaction findTransactionById(int id);

    List<Transaction> findTransactionsByDate(LocalDate date);

    List<Transaction> findTransactionsByMonth(int month);

    void saveTransaction(Transaction transaction);

    void updateTransaction(Transaction transaction);

    Transaction deleteTransactionById(int id);
}
