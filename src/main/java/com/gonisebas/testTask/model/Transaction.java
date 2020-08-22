package com.gonisebas.testTask.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import com.gonisebas.testTask.TransactionType;

public class Transaction {

    private UUID id;
    private TransactionType type;
    private BigDecimal amount;
    private Date date;

   

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public TransactionType getType() {
        return type;
    }
    public void setType(TransactionType type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    
    
}
