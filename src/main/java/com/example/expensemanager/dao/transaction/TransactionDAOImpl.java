package com.example.expensemanager.dao.transaction;

import com.example.expensemanager.entity.Transaction;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class TransactionDAOImpl implements TransactionDAO{

    private EntityManager entityManager;

    public TransactionDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Transaction> findAllTransactions() {
        TypedQuery<Transaction> query = entityManager.createQuery("from Transaction" , Transaction.class);
        return query.getResultList();
    }

    @Override
    public Transaction findTransactionById(int id) {
        Transaction transaction = entityManager.find(Transaction.class, id);
        if(transaction == null) {
            return null;
        }
        return transaction;
    }

    @Override
    public List<Transaction> findTransactionsByDate(LocalDate date) {
        TypedQuery<Transaction> query = entityManager.createQuery("select t from Transaction t " +
                "where t.date =: data", Transaction.class);

        query.setParameter("data", date);

        return query.getResultList();
    }

    @Override
    public List<Transaction> findTransactionsByMonth(int month) {
        if(month < 1 || month > 12) {
            return null;
        }
        List<Transaction> monthlyTransactionsList = new ArrayList<>();
        TypedQuery<Transaction> query = entityManager.createQuery("from Transaction" , Transaction.class);
        List<Transaction> list = query.getResultList();
        for(Transaction transaction : list) {
            if(transaction.getDate().getMonthValue() == month) {
                monthlyTransactionsList.add(transaction);
            }
        }
        return monthlyTransactionsList;
    }

//    @Override
//    public List<Transaction> findTransactionsByMonth(int month) {
//        TypedQuery<Transaction> query = entityManager.createQuery("select t from Transaction t " +
//                "where t.date =: month", Transaction.class);
//        return null;
//    }

    @Override
    public void saveTransaction(Transaction transaction) {
        entityManager.persist(transaction);
    }

    @Override
    public void updateTransaction(Transaction transaction) {
        entityManager.merge(transaction);
    }

    @Override
    public Transaction deleteTransactionById(int id) {
        Transaction transaction = entityManager.find(Transaction.class, id);
        if(transaction == null) {
            return null;
        }
        entityManager.remove(transaction);
        return transaction;
    }
}
