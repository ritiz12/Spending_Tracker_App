package com.example.SpendingRecorder_App.SpendingRecorder.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;

@Entity
@Table(name = "spend")
public class Spend {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id ;


    @NotNull(message = "Amount Field is Mandatory")
    @Column(name = "amount" , updatable = false , nullable = false)
    private BigDecimal amount ;

    @NotNull(message = "Currency Field is Mandatory")
     @Column(name = "currency" , updatable = false , nullable = false)
     private Currency currency ;


    @Column(name = "purchaseDate" , updatable = false , nullable = false)
    private Date purchaseDate ;


    @NotNull(message = "Purchase Month is Mandatory")
    @Column(name = "purchaseMonth" , updatable = false , nullable = false)
    private Integer purchaseMonth ;


    @NotNull(message = "Product Name is Mandatory")
    @NotBlank(message = "Product Name is Mandatory")
    @Column(name = "product" , updatable = false , nullable = false)
    private String product ;

    @NotNull(message = "Purchase Year is Mandatory")
    @Column(name = "purchaseYear" , updatable = false , nullable = false)
    private Integer purchaseYear  ;

    Spend()
    {
        super();
    }

    public Spend(
                 final  String product,
                 final  BigDecimal amount,
                 final Currency currency ,
                 final  Date purchaseDate,
                 final  Integer purchaseMonth,
                 final Integer purchaseYear) {

        this.product = product;
        this.amount = amount;
        this.currency = currency ;
        this.purchaseDate = purchaseDate;
        this.purchaseMonth = purchaseMonth;
        this.purchaseYear = purchaseYear;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {

        if(amount != null) {
            this.amount = amount;
        }
        else
        {
            throw new IllegalArgumentException("Amount Field is Mandatory");
        }
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {

        if(purchaseDate != null) {
            this.purchaseDate = purchaseDate;
        }
        else
        {
            throw new IllegalArgumentException("PurchaseDate Field is Mandatory");
        }
    }

    public Integer getPurchaseMonth() {
        return purchaseMonth;
    }

    public void setPurchaseMonth(Integer purchaseMonth) {

        if(purchaseMonth != null) {
            this.purchaseMonth = purchaseMonth;
        }
        else
        {
            throw new IllegalArgumentException("PurchaseMonth Field is Mandatory");
        }
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {

        if(product != null)
        {
            this.product = product;
        }
        else
        {
            throw new IllegalArgumentException("Product Field is Mandatory");
        }

    }

    public Integer getPurchaseYear() {
        return purchaseYear;
    }

    public void setPurchaseYear(Integer purchaseYear) {
        if(purchaseYear != null) {
            this.purchaseYear = purchaseYear;
        }
        else
        {
            throw new IllegalArgumentException(" purchaseYear Field is Mandatory");
        }
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        if(currency != null) {
            this.currency = currency;
        }
        else
        {
            throw new IllegalArgumentException("Currency Field is Mandatory");
        }
    }
}

