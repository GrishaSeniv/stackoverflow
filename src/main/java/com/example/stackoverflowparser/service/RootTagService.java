package com.example.stackoverflowparser.service;

import com.example.stackoverflowparser.model.RootTag;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RootTagService {
    @GET("/users/{id}/tags?site=stackoverflow")
    Call<RootTag> getTags(@Path("id") Long id, @Query("page") int page);
}
