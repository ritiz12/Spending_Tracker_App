package com.example.SpendingRecorder_App.SpendingRecorder.persistence;

import com.example.SpendingRecorder_App.SpendingRecorder.data.GetPreviousRecordSummary;
import com.example.SpendingRecorder_App.SpendingRecorder.domain.Spend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SpendRepository extends JpaRepository<Spend , Integer > {
    @Query(value = "SELECT amount, product, currency, purchaseDate FROM Spend WHERE purchaseDate < :todayDate")
    List<GetPreviousRecordSummary> displayPreviousData(@Param("todayDate") Date todayDate);
}
