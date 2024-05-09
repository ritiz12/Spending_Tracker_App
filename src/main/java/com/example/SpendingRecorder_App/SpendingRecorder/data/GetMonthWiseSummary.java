package com.example.SpendingRecorder_App.SpendingRecorder.data;

import java.math.BigDecimal;

public class GetMonthWiseSummary
{

    private BigDecimal totalAmount;
    private Integer purchaseMonth;
    private Integer purchaseYear;

    public GetMonthWiseSummary(BigDecimal totalAmount, Integer purchaseMonth, Integer purchaseYear) {
        this.totalAmount = totalAmount;
        this.purchaseMonth = purchaseMonth;
        this.purchaseYear = purchaseYear;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getPurchaseMonth() {
        return purchaseMonth;
    }

    public void setPurchaseMonth(Integer purchaseMonth) {
        this.purchaseMonth = purchaseMonth;
    }

    public Integer getPurchaseYear() {
        return purchaseYear;
    }

    public void setPurchaseYear(Integer purchaseYear) {
        this.purchaseYear = purchaseYear;
    }
}