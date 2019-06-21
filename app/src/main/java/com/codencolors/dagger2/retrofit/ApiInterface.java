package com.codencolors.dagger2.retrofit;

import com.codencolors.dagger2.model.TopHeadlines;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("top-headlines")
    Call<TopHeadlines> getTopHeadlines(@Query("sources") String sources, @Query("apiKey") String apiKey);
}
