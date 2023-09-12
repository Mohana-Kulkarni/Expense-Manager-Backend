package com.example.expensemanager.dto;

import com.example.expensemanager.entity.Transaction;
import com.example.expensemanager.entity.Type;

import java.util.List;

public class TypeTransactionResponse {

    private Type type;

    private List<Transaction> transactionList;

    public TypeTransactionResponse() {

    }

    public TypeTransactionResponse(Type type, List<Transaction> transactionList) {
        this.type = type;
        this.transactionList = transactionList;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    @Override
    public String toString() {
        return "TypeTransactionResponse{" +
                "type=" + type +
                ", transactionList=" + transactionList +
                '}';
    }
}

