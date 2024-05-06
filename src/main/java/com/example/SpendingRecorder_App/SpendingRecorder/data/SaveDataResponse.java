package com.example.SpendingRecorder_App.SpendingRecorder.data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class SaveDataResponse {
private Collection<SaveDataSummary> spendRecord ;
public void addSpendData(final SaveDataSummary data)
{
    if(spendRecord == null)
    {
        spendRecord = new ArrayList<>();
    }
    spendRecord.add(data);
}

public Collection<SaveDataSummary> getSpendRecord()
{
    return new ArrayList<>(spendRecord);
}

}
