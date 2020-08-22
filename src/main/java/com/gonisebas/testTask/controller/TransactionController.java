package com.gonisebas.testTask.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gonisebas.testTask.InsufficientBalanceException;
import com.gonisebas.testTask.TransactionService;
import com.gonisebas.testTask.model.Transaction;

@RestController
public class TransactionController {
    
    @Autowired
    TransactionService service;

    
    @GetMapping("/transactions")
    public List<Transaction> getAll() {
      return service.getAll();
    }
    
    @GetMapping("/transactions/{transactionId}")
    public Transaction get(@PathVariable UUID transactionId) {
      return service.get(transactionId);
    }
    
    @PostMapping("transactions")
    public void add(@RequestBody Transaction transaction, HttpServletResponse response) {
        try {
            service.add(transaction);
        } catch (InsufficientBalanceException e) {
            
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
    
}
