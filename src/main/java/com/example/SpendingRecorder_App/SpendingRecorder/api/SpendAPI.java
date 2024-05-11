package com.example.SpendingRecorder_App.SpendingRecorder.api;

import com.example.SpendingRecorder_App.SpendingRecorder.core.SpendService;
import com.example.SpendingRecorder_App.SpendingRecorder.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/spend")
@RestController()
@CrossOrigin(origins = "http://localhost:5173")
public class SpendAPI {

    @Autowired
    SpendService spendService ;

    @CrossOrigin
    @PostMapping("/save")
    public ResponseEntity<SaveDataResponse> saveSpendingData(@RequestBody SaveDataRequest request)
    {
        final var response = spendService.saveSpendingData(request);
        return ResponseEntity.ok(response);

    }

   // @CrossOrigin
    @GetMapping("/previousRecord")
    public ResponseEntity<GetPreviousRecordResponse> getPreviousRecord( GetPreviousRecordRequest request)
    {
        final var response = spendService.getPreviousRecord(request);
        return ResponseEntity.ok(response);
    }

   // @CrossOrigin
   @GetMapping("/monthlyRecord")
    public ResponseEntity<GetMonthWiseResponse> getMonthlyRecord(GetMonthWiseRequest request)
    {
        final var response = spendService.getMonthlyRecord(request);
        return ResponseEntity.ok(response);
    }

}
