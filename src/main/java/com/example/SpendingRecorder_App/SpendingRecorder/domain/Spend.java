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
        this.amount = amount;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Integer getPurchaseMonth() {
        return purchaseMonth;
    }

    public void setPurchaseMonth(Integer purchaseMonth) {
        this.purchaseMonth = purchaseMonth;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getPurchaseYear() {
        return purchaseYear;
    }

    public void setPurchaseYear(Integer purchaseYear) {
        this.purchaseYear = purchaseYear;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
