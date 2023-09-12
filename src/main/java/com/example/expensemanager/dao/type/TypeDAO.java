package com.example.expensemanager.dao.type;

import com.example.expensemanager.entity.Transaction;
import com.example.expensemanager.entity.Type;

import java.util.List;

public interface TypeDAO {

    Type getTypeById(int id);
    Type getTransactionsByTypeId(int id);
}
