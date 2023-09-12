package com.example.expensemanager.rest;

import com.example.expensemanager.dto.CategoryTransactionResponse;
import com.example.expensemanager.entity.Category;
import com.example.expensemanager.entity.Transaction;
import com.example.expensemanager.service.category.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryRestController {

    private CategoryService categoryService;

    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public List<Category> getCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{categoryId}")
    public Category getCategoryById(@PathVariable int categoryId) {
        return categoryService.getCategoryById(categoryId);
    }

    @PostMapping("/")
    public void addCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
    }

    @PutMapping("/{categoryId}")
    public void updateCategory(@PathVariable int categoryId, @RequestBody Category category) {
        categoryService.updateCategory(category);
    }

    @DeleteMapping("/{categoryId}")
    public Category deleteCategory(@PathVariable int categoryId) {
        return categoryService.deleteCategoryById(categoryId);
    }

    @GetMapping("/transactions/{categoryId}")
    public CategoryTransactionResponse getTransactionsByCategory(@PathVariable int categoryId) {
        return categoryService.getTransactionsByCategoryId(categoryId);
    }
}
