package com.example.stackoverflowparser.service;

import com.example.stackoverflowparser.model.Total;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TotalQuestionService {
    @GET("/users/{id}/questions?site=stackoverflow&filter=!Nfq4bHcltk388")
    Call<Total> getTotalQuestion(@Path("id") Long id);
}
