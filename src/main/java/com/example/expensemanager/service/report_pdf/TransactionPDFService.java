package com.example.expensemanager.service.report_pdf;

import com.example.expensemanager.entity.Transaction;
import com.example.expensemanager.repos.ITransactionService;
import com.example.expensemanager.repos.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionPDFService implements ITransactionService {

    private final TransactionRepository repository;

    @Autowired
    public TransactionPDFService(TransactionRepository repository) {
        this.repository = repository;
    }
    @Override
    public List<Transaction> findAll() {
        return (List<Transaction>) repository.findAll();
    }
}
