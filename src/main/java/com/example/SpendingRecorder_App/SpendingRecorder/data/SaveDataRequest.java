package com.example.SpendingRecorder_App.SpendingRecorder.data;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;

public class SaveDataRequest {
    final private BigDecimal amount;
    final private Date purchaseDate;

    final private String product ;

    final private Currency currency ;

    public SaveDataRequest(BigDecimal amount, Date purchaseDate, String product , Currency currency) {
        this.amount = amount;
        this.purchaseDate = purchaseDate;
        this.product = product;
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public String getProduct() {
        return product;
    }

    public Currency getCurrency() {
        return currency;
    }
}
