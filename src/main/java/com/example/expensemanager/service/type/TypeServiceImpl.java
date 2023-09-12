package com.example.expensemanager.service.type;

import com.example.expensemanager.dao.type.TypeDAO;
import com.example.expensemanager.dto.TypeTransactionResponse;
import com.example.expensemanager.entity.Transaction;
import com.example.expensemanager.entity.Type;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService{

    private TypeDAO typeDAO;

    public TypeServiceImpl(TypeDAO typeDAO) {
        this.typeDAO = typeDAO;
    }

    @Override
    public Type getTypeById(int id) {
        return typeDAO.getTypeById(id);
    }

    @Override
    public TypeTransactionResponse getTransactionsByTypeId(int id) {
        Type type = typeDAO.getTransactionsByTypeId(id);
        List<Transaction> transactionList = type.getTransactions();
        return new TypeTransactionResponse(type, transactionList);
    }
}
