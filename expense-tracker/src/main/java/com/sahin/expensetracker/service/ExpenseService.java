package com.sahin.expensetracker.service;

import com.sahin.expensetracker.model.Expense;
import com.sahin.expensetracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository repository;

    public Collection<Expense> expenses(){
        return repository.findAll();
    }

    public void deleteExpense(Long id){
        repository.deleteById(id);
    }

    public Expense createExpense(Expense expense){
        return repository.save(expense);
    }

}
