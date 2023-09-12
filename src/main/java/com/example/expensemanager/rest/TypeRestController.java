package com.example.expensemanager.rest;

import com.example.expensemanager.dto.TypeTransactionResponse;
import com.example.expensemanager.entity.Type;
import com.example.expensemanager.service.type.TypeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/type/")
public class TypeRestController {

    private TypeService typeService;

    public TypeRestController(TypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping("{typeId}")
    public Type getTypeById(@PathVariable int typeId) {
        return typeService.getTypeById(typeId);
    }

    @GetMapping("/transactions/{typeId}")
    public TypeTransactionResponse getTransactionsByType(@PathVariable int typeId) {
        return typeService.getTransactionsByTypeId(typeId);
    }
}
