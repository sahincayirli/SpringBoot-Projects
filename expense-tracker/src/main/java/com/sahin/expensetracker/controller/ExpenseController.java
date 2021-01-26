package com.sahin.expensetracker.controller;

import com.sahin.expensetracker.model.Expense;
import com.sahin.expensetracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

@RestController
@RequestMapping("/api")
public class ExpenseController {

    @Autowired
    private ExpenseService service;

    @GetMapping("/expenses")
    private Collection<Expense> expenses(){
        return service.expenses();
    }

    @DeleteMapping("/expense/{id}")
    private ResponseEntity<?> deleteExpense(@PathVariable Long id){
        service.deleteExpense(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/expense")
    private ResponseEntity<Expense> createExpense(@RequestBody Expense expense) throws URISyntaxException {
        Expense result = service.createExpense(expense);
        return ResponseEntity.created(new URI("/api/expense" + result.getId())).body(result);
    }

}
