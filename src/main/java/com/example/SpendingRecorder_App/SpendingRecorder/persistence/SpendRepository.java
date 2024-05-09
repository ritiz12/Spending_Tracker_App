package com.example.SpendingRecorder_App.SpendingRecorder.persistence;

import com.example.SpendingRecorder_App.SpendingRecorder.data.GetMonthWiseSummary;
import com.example.SpendingRecorder_App.SpendingRecorder.data.GetPreviousRecordSummary;
import com.example.SpendingRecorder_App.SpendingRecorder.domain.Spend;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SpendRepository extends JpaRepository<Spend , Integer>  {
    @Query(value = "SELECT amount, product, currency, purchaseDate FROM Spend WHERE purchaseDate < :todayDate")
    List<GetPreviousRecordSummary> displayPreviousData(@Param("todayDate") Date todayDate);


    @Query("SELECT new com.example.SpendingRecorder_App.SpendingRecorder.data.GetMonthWiseSummary(SUM(s.amount) as totalAmount, s.purchaseYear as purchaseYear, s.purchaseMonth AS purchaseMonth) " +
            "FROM Spend s " +
            "LEFT JOIN Record r ON (s.purchaseYear * 10 + s.purchaseMonth) = r.monthYear " +
            "WHERE (s.purchaseYear * 10 + s.purchaseMonth) >= :previousMonthYear AND (s.purchaseYear * 10 + s.purchaseMonth) <= :currentMonthYear " +
            "GROUP BY s.purchaseMonth ORDER BY s.purchaseYear")
    List<GetMonthWiseSummary> getMonthlyAmount(@Param("currentMonthYear") Integer currentMonthYear, @Param("previousMonthYear") Integer previousMonthYear);

}







