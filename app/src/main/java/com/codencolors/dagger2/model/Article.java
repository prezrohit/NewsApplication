package com.codencolors.dagger2.model;

import java.util.ArrayList;

public class Article {

    private Source source;
    private String author;
    private String title;
    private String url;
    private String publishedAt;
    private ArrayList<String> stringArrayList;

    public Source getSource() {
        return source;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getPublishedAt() {
        return publishedAt;
    }
}
