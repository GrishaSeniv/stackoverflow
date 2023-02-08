package com.example.stackoverflowparser.util;

import com.example.stackoverflowparser.model.RootItem;
import com.example.stackoverflowparser.model.RootTag;
import com.example.stackoverflowparser.model.Total;
import com.example.stackoverflowparser.service.RootItemService;
import com.example.stackoverflowparser.service.RootTagService;
import com.example.stackoverflowparser.service.TotalAnswerService;
import com.example.stackoverflowparser.service.TotalQuestionService;
import java.io.IOException;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtil {
    private static final String BASE_URL = "https://api.stackexchange.com/2.3/";
    private static final OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build();

    public RootItem getRoots(int page) {
        RootItemService rootItemService = retrofit.create(RootItemService.class);
        Call<RootItem> root = rootItemService.getRoot(page);
        try {
            return root.execute().body();
        } catch (IOException e) {
            throw new RuntimeException("Couldn't get roots, page: " + page + ". "
                    + e);
        }
    }

    public Total getTotalAnswers(Long id) {
        TotalAnswerService service = retrofit.create(TotalAnswerService.class);
        Call<Total> totalAnswers = service.getTotalAnswers(id);
        try {
            return totalAnswers.execute().body();
        } catch (IOException e) {
            throw new RuntimeException("Couldn't get total answers for user id: " + id + ". "
                    + e);
        }
    }

    public Total getTotalQuestions(Long id) {
        TotalQuestionService service = retrofit.create(TotalQuestionService.class);
        Call<Total> totalQuestions = service.getTotalQuestion(id);
        try {
            return totalQuestions.execute().body();
        } catch (IOException e) {
            throw new RuntimeException("Couldn't get total questions for user id: " + id + ". "
                    + e);
        }
    }

    public RootTag getTags(Long id, int page) {
        RootTagService service = retrofit.create(RootTagService.class);
        Call<RootTag> call = service.getTags(id, page);
        try {
            return call.execute().body();
        } catch (IOException e) {
            throw new RuntimeException("Couldn't get tags for user id: " + id + ". "
                    + e);
        }
    }
}
