package com.example.SpendingRecorder_App.SpendingRecorder.api;

import com.example.SpendingRecorder_App.SpendingRecorder.core.SpendService;
import com.example.SpendingRecorder_App.SpendingRecorder.data.GetPreviousRecordRequest;
import com.example.SpendingRecorder_App.SpendingRecorder.data.GetPreviousRecordResponse;
import com.example.SpendingRecorder_App.SpendingRecorder.data.SaveDataRequest;
import com.example.SpendingRecorder_App.SpendingRecorder.data.SaveDataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/spend")
@RestController()
public class SpendAPI {

    @Autowired
    SpendService spendService ;

    @PostMapping("/save")
    public ResponseEntity<SaveDataResponse> saveSpendingData(@RequestBody SaveDataRequest request)
    {
        final var response = spendService.saveSpendingData(request);
        return ResponseEntity.ok(response);

    }

    @GetMapping("/previousRecord")
    public ResponseEntity<GetPreviousRecordResponse> getPreviousRecord( GetPreviousRecordRequest request)
    {
        final var response = spendService.getPreviousRecord(request);
        return ResponseEntity.ok(response);
    }




}
