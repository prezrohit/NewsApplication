package com.codencolors.dagger2.model;

import java.util.ArrayList;

public class TopHeadlines {

    private String status;
    private String totalResults;
    private ArrayList<Article> articles;

    public String getStatus() {
        return status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }
}
