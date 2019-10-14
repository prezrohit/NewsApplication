package com.codencolors.dagger2.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.codencolors.dagger2.NewsApplication;
import com.codencolors.dagger2.R;
import com.codencolors.dagger2.adapter.NewsAdapter;
import com.codencolors.dagger2.model.Article;
import com.codencolors.dagger2.model.TopHeadlines;
import com.codencolors.dagger2.retrofit.ApiClient;
import com.codencolors.dagger2.retrofit.ApiInterface;

import java.util.ArrayList;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @Inject
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final String apiKey = "your sample api key";  
        
        // in this case you can get it at newsapi.org. create an account and you get the api key

        final ProgressBar progressBar = findViewById(R.id.mainProgressBar);
        progressBar.setIndeterminate(true);
        final RecyclerView rvNews = findViewById(R.id.rv_news);
        rvNews.setLayoutManager(new LinearLayoutManager(this));

        ((NewsApplication)getApplication()).getHeadlineComponent().inject(this);
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Call<TopHeadlines> call = apiInterface.getTopHeadlines("techcrunch", apiKey);
        call.enqueue(new Callback<TopHeadlines>() {
            @Override
            public void onResponse(Call<TopHeadlines> call, Response<TopHeadlines> response) {

                progressBar.setVisibility(View.GONE);
                TopHeadlines topHeadlines = response.body();
                Log.d(TAG, "Response Message: " + response.message());
                Log.d(TAG, "Response Status: " + topHeadlines.getStatus());
                Log.d(TAG, "Response Count: " + topHeadlines.getTotalResults());
                ArrayList<Article> articlesList = topHeadlines.getArticles();
                NewsAdapter newsAdapter = new NewsAdapter(MainActivity.this, articlesList);
                rvNews.setAdapter(newsAdapter);
                rvNews.addItemDecoration(new DividerItemDecoration(MainActivity.this, DividerItemDecoration.VERTICAL));
            }

            @Override
            public void onFailure(Call<TopHeadlines> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });
    }
}
