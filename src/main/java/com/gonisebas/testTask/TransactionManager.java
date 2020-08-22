package com.gonisebas.testTask;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.gonisebas.testTask.model.Transaction;

@Component
public class TransactionManager {
    
    private List<Transaction> transactions = new ArrayList<Transaction>();    
    private BigDecimal totalAmount = BigDecimal.ZERO;
    
    
    public synchronized  void add(Transaction transaction) throws InsufficientBalanceException {
        switch (transaction.getType()) {
        case DEBIT:
            this.substract(transaction.getAmount());
            break;
        case CREDIT:
            this.sum(transaction.getAmount());
            break;
        }
        transactions.add(transaction);
    }
    
    public List<Transaction> getAll(){
        return transactions;
    }
    
    private void sum(BigDecimal amount) {
        totalAmount = totalAmount.add(amount);
    }
    
    private void substract(BigDecimal amount) throws InsufficientBalanceException {
        if (totalAmount.subtract(amount).compareTo(BigDecimal.ZERO) < 0) {
            throw new InsufficientBalanceException();
        }
        totalAmount = totalAmount.subtract(amount);
    }

    public Transaction get(UUID transactionId) {
        return transactions.stream()
                        .filter(t -> transactionId.equals(t.getId()))
                        .findAny()
                        .orElse(null);
    }

}
