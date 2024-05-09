package com.example.SpendingRecorder_App.SpendingRecorder.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "Record")
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id ;
    @Column(name = "month" , nullable = false , updatable = false)
    private Integer month ;

    @Column(name = "year" , nullable = false , updatable = false)
    private Integer year ;

    @Column(name = "monthYear" , nullable = false , updatable = false)
    private Long monthYear ;


    public Record(Integer id, Integer month, Integer year , Long monthYear ) {
        this.id = id;
        this.month = month;
        this.year = year;
        this.monthYear = monthYear ;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Long getMonthYear() {
        return monthYear;
    }

    public void setMonthYear(Long monthYear) {
        this.monthYear = monthYear;
    }
}
