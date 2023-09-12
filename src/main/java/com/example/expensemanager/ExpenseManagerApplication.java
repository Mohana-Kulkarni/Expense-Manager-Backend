package com.example.expensemanager;

import com.example.expensemanager.entity.Category;
import com.example.expensemanager.entity.Transaction;
import com.example.expensemanager.entity.Type;
import com.example.expensemanager.service.category.CategoryService;
import com.example.expensemanager.service.transaction.TransactionService;
import com.example.expensemanager.service.type.TypeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class ExpenseManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseManagerApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(TransactionService transactionService, CategoryService categoryService, TypeService typeService) {
		return runner -> {
//			addTransaction(transactionService, categoryService, typeService);

//			getTransactionByDate(transactionService);

//			createNewCategory(categoryService);

//			updateExistingCategory(categoryService);

//			deleteCategory(categoryService);

//			getCategories(categoryService);
//
//			getCategoriesById(categoryService);

//			getTransactionsById(categoryService);

//			getTransactionsByType(typeService);
		};

	}

//	private void getTransactionsByType(TypeService typeService) {
//		int theId = 1;
//		Type type = typeService.getTransactionsByTypeId(theId);
//		List<Transaction> transactionList = type.getTransactions();
//		System.out.println(transactionList);
//	}

	private void getTransactionsById(CategoryService categoryService) {
		int theId = 1;
//		Category category = categoryService.getTransactionsByCategoryId(theId);
//		List<Transaction> transactionList= category.getTransactions();
//		System.out.println(transactionList);
	}

	private void getCategoriesById(CategoryService categoryService) {
		int theId = 5;
		Category categories = categoryService.getCategoryById(theId);
		System.out.println(categories);
	}
	private void getCategories(CategoryService categoryService) {
		List<Category> categories = categoryService.getAllCategories();
		System.out.println(categories);
	}

	private void getTransactionByDate(TransactionService transactionService) {
		LocalDate localDate = LocalDate.now();
		List<Transaction> transaction =  transactionService.findTransactionsByDate(localDate);
		System.out.println("Date : " + localDate);
		System.out.println("Transactions : " + transaction);
		System.out.println("Done!");

	}

	private void addTransaction(TransactionService transactionService, CategoryService categoryService, TypeService typeService) {
		Transaction transaction = new Transaction("Snacks", "Canteen", 120, LocalDate.now());
		Category category = categoryService.getCategoryById(1);
		Type type = typeService.getTypeById(1);
		transactionService.saveTransaction(transaction);
		transaction.setCategory(category);
		transaction.setType(type);
		transactionService.updateTransaction(transaction);
		System.out.println("Done!");
	}

//	private void deleteCategory(CategoryService categoryService) {
//
//		int theId = 8;
//		categoryService.deleteCategoryById(theId);
//		System.out.println("Deleted category of ID : " + theId);
//	}
//
//	private void updateExistingCategory(CategoryService categoryService) {
//		int theId = 6;
//		Category category = categoryService.getCategoryById(theId);
//		category.setName("Other");
//		categoryService.updateCategory(category);
//		System.out.println("Done!");
//	}
//
//	private void createNewCategory(CategoryService categoryService) {
//		Category category = new Category("Others");
//		categoryService.addCategory(category);
//	}

}
