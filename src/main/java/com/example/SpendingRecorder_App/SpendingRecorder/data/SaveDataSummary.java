package com.example.SpendingRecorder_App.SpendingRecorder.data;

import java.math.BigDecimal;
import java.util.Currency;

public class SaveDataSummary {
    final private BigDecimal amount;
    final private String purchaseDate;

    final private String product ;

    final  private Integer purchaseMonth ;

    final  private Integer purchaseYear  ;

    final private Currency currency ;

    public SaveDataSummary(String product, BigDecimal amount, Currency currency , String purchaseDate, Integer purchaseMonth, Integer purchaseYear) {
        this.product = product;
        this.amount = amount;
        this.currency = currency ;
        this.purchaseDate = purchaseDate;
        this.purchaseMonth = purchaseMonth;
        this.purchaseYear = purchaseYear;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public String getProduct() {
        return product;
    }

    public Integer getPurchaseMonth() {
        return purchaseMonth;
    }

    public Integer getPurchaseYear() {
        return purchaseYear;
    }


}
