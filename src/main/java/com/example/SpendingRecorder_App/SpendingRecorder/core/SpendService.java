package com.example.SpendingRecorder_App.SpendingRecorder.core;

import com.example.SpendingRecorder_App.SpendingRecorder.data.*;
import com.example.SpendingRecorder_App.SpendingRecorder.domain.Spend;
import com.example.SpendingRecorder_App.SpendingRecorder.persistence.SpendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.temporal.TemporalAccessor;
import java.util.*;

@Service
public class SpendService {

    @Autowired
    SpendRepository spendRepository ;
    public SaveDataResponse saveSpendingData(final SaveDataRequest request) {
        Calendar calendar = Calendar.getInstance();
         Date date = request.getPurchaseDate();
        calendar.setTime(date);
        Integer purchaseMonth = calendar.get(Calendar.MONTH) + 1 ;
        Integer purchaseYear = calendar.get(Calendar.YEAR)   ;
        SimpleDateFormat formatter = new SimpleDateFormat("MMM d, yyyy", Locale.ENGLISH);
        String formattedDate = formatter.format(date);
     Spend spend = new Spend(request.getProduct(),request.getAmount() , request.getCurrency() , request.getPurchaseDate() , purchaseMonth , purchaseYear );
      spendRepository.save(spend);

      final var response = new SaveDataResponse();
       response.addSpendData(new SaveDataSummary(spend.getProduct() ,
               spend.getAmount() ,
               spend.getCurrency() ,
               formattedDate ,
               spend.getPurchaseMonth() ,
               spend.getPurchaseYear()));
       return response ;

    }


    public GetPreviousRecordResponse getPreviousRecord(final GetPreviousRecordRequest request) {
        Pageable pageable = PageRequest.of(0, 100, Sort.by(Sort.Direction.DESC, "purchaseDate"));
        Page<Spend> spendPage = spendRepository.findAll(pageable);
        if(spendPage.isEmpty()) {
            throw new IllegalStateException("No Previous Data is Found");
        }
        List<GetPreviousRecordSummary> spendRecordList = new ArrayList<>();
        for(Spend spend : spendPage.getContent())
        {
            spendRecordList.add(new GetPreviousRecordSummary(spend.getProduct() , spend.getAmount() ,  spend.getPurchaseDate(), spend.getCurrency() ));
        }
           final long totalCount = spendRepository.count();
        Page<GetPreviousRecordSummary> page = new PageImpl<>(spendRecordList , pageable , totalCount);
        return  new GetPreviousRecordResponse(page);
    }

   public GetMonthWiseResponse getMonthlyRecord(final GetMonthWiseRequest request) {
        Date date = new Date();
       Calendar calendar = Calendar.getInstance();
       calendar.setTime(date);
       String currentMonth = String.valueOf(calendar.get(Calendar.MONTH) + 1);
       String currentYear = String.valueOf(calendar.get(Calendar.YEAR));
       String currentMonthYear = currentYear + "" + currentMonth;
       Integer currentMonthYearLong = Integer.parseInt(currentMonthYear);
       String previousMonth = String.valueOf(calendar.get(Calendar.MONTH) - 2 );
       String previousYear = String.valueOf(calendar.get(Calendar.YEAR) - 3 );

       String previousMonthYear = previousYear + "" + previousMonth;
       Integer previousMonthYearLong = Integer.parseInt(previousMonthYear);
       List<GetMonthWiseSummary> monthlyRecordList = spendRepository.getMonthlyAmount(currentMonthYearLong , previousMonthYearLong);
       final var response = new GetMonthWiseResponse();
       for(var record : monthlyRecordList)
       {
           response.addMonthlyRecord(new GetMonthWiseSummary(record.getTotalAmount() , record.getPurchaseMonth() , record.getPurchaseYear()));
       }
       return response ;
    }




}
