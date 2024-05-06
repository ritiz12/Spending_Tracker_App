package com.example.SpendingRecorder_App.SpendingRecorder.data;

import com.example.SpendingRecorder_App.SpendingRecorder.common.PaginatedResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.Collection;

public class GetPreviousRecordResponse extends PaginatedResponse {

  private final Page<GetPreviousRecordSummary> page;

    public GetPreviousRecordResponse(Page<GetPreviousRecordSummary> page) {
        this.page = page;
    }

    @JsonProperty
    public Page<GetPreviousRecordSummary> getPage() {
        return page ;
    }
}
