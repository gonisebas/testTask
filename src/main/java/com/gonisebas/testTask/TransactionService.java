package com.gonisebas.testTask;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gonisebas.testTask.model.Transaction;

@Service
public class TransactionService {
    
    @Autowired
    TransactionManager manager;
    
    
    public List<Transaction> getAll(){
        return manager.getAll();
    }

    public void add(Transaction transaction) throws InsufficientBalanceException {
        transaction.setDate(new Date());
        transaction.setId(UUID.randomUUID());
        manager.add(transaction);        
    }

    public Transaction get(UUID transactionId) {
        return manager.get(transactionId);
    }

}
