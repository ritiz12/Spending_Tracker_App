package com.example.SpendingRecorder_App.SpendingRecorder.data;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;

public class GetPreviousRecordSummary {
    final private String product ;
    final private BigDecimal amount ;

    final private  Date purchaseDate ;

    final private Currency currency ;

    public GetPreviousRecordSummary(String product, BigDecimal amount, Date purchaseDate, Currency currency) {
        this.product = product;
        this.amount = amount;
        this.purchaseDate = purchaseDate;
        this.currency = currency;
    }

    public String getProduct() {
        return product;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public Currency getCurrency() {
        return currency;
    }
}
