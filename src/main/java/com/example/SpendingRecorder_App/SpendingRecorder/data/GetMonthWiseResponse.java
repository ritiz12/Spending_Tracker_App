package com.example.SpendingRecorder_App.SpendingRecorder.data;

import java.util.ArrayList;
import java.util.Collection;

public class GetMonthWiseResponse {

    Collection<GetMonthWiseSummary> monthlyRecord;

    public void addMonthlyRecord(final GetMonthWiseSummary data) {
        if (monthlyRecord == null) {
            monthlyRecord = new ArrayList<>();
        }
        monthlyRecord.add(data);

    }

    public Collection<GetMonthWiseSummary> getMonthlyRecord() {
        return monthlyRecord;
    }
}
