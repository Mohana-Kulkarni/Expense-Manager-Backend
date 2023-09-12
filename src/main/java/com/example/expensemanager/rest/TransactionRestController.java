package com.example.expensemanager.rest;

import com.example.expensemanager.entity.Category;
import com.example.expensemanager.entity.Transaction;
import com.example.expensemanager.entity.Type;
import com.example.expensemanager.service.category.CategoryService;
import com.example.expensemanager.service.transaction.TransactionService;
import com.example.expensemanager.service.type.TypeService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/transaction/")
public class TransactionRestController {

    private TransactionService transactionService;
    private CategoryService categoryService;

    private TypeService typeService;

    public TransactionRestController(TransactionService transactionService, CategoryService categoryService, TypeService typeService) {
        this.transactionService = transactionService;
        this.categoryService = categoryService;
        this.typeService = typeService;
    }

    @GetMapping("/")
    public List<Transaction> getTransactions() {
        return transactionService.findAllTransactions();
    }

    @GetMapping("/{transactionId}")
    public Transaction getTransactionById(@PathVariable int transactionId) {
        return transactionService.findTransactionById(transactionId);
    }

    @GetMapping("/date={date}")
    public List<Transaction> getTransactionsByDate(@PathVariable LocalDate date){
        List<Transaction> transactionList = transactionService.findTransactionsByDate(date);
        return transactionList;
    }

    @GetMapping("/month={monthId}")
    public List<Transaction> getTransactionsByMonth(@PathVariable int monthId) {

        return transactionService.findTransactionsByMonth(monthId);
    }
    @PostMapping("/category={categoryId}/type={typeId}")
    public void addTransaction(@PathVariable int categoryId, @PathVariable int typeId, @RequestBody Transaction transaction) {
        Category category = categoryService.getCategoryById(categoryId);
        Type type = typeService.getTypeById(typeId);
        transaction.setCategory(category);
        transaction.setType(type);
        transactionService.saveTransaction(transaction);
    }

    @PutMapping("/{transactionId}")
    public void updateTransaction(@PathVariable int transactionId, @RequestBody Transaction transaction) {
        transactionService.updateTransaction(transaction);
    }

    @DeleteMapping("/{transactionId}")
    public Transaction deleteTransaction(@PathVariable int transactionId) {
        return transactionService.deleteTransactionById(transactionId);
    }
}
