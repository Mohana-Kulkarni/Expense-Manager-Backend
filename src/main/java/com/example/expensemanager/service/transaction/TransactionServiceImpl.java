package com.example.expensemanager.service.transaction;

import com.example.expensemanager.dao.transaction.TransactionDAO;
import com.example.expensemanager.entity.Transaction;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{

    private TransactionDAO transactionDAO;

    public TransactionServiceImpl(TransactionDAO transactionDAO) {
        this.transactionDAO = transactionDAO;
    }

    @Override
    public List<Transaction> findAllTransactions() {
        return transactionDAO.findAllTransactions();
    }

    @Override
    public Transaction findTransactionById(int id) {
        return transactionDAO.findTransactionById(id);
    }

    @Override
    public List<Transaction> findTransactionsByDate(LocalDate date) {
        return transactionDAO.findTransactionsByDate(date);
    }

    @Override
    public List<Transaction> findTransactionsByMonth(int month) {
        return transactionDAO.findTransactionsByMonth(month);
    }

    @Override
    @Transactional
    public void saveTransaction(Transaction transaction) {
        transactionDAO.saveTransaction(transaction);
    }

    @Override
    @Transactional
    public void updateTransaction(Transaction transaction) {
        transactionDAO.updateTransaction(transaction);
    }

    @Override
    @Transactional
    public Transaction deleteTransactionById(int id) {
        return transactionDAO.deleteTransactionById(id);
    }
}
