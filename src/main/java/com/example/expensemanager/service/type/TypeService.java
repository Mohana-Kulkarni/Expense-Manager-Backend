package com.example.expensemanager.service.type;

import com.example.expensemanager.dto.TypeTransactionResponse;
import com.example.expensemanager.entity.Transaction;
import com.example.expensemanager.entity.Type;

import java.util.List;

public interface TypeService {

    Type getTypeById(int id);

    TypeTransactionResponse getTransactionsByTypeId(int id);
}
