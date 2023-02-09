package com.example.stackoverflowparser.service;

import com.example.stackoverflowparser.model.RootItem;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RootItemService {
    @GET("/users?site=stackoverflow")
    Call<RootItem> getRoot(@Query("page") int page);
}
