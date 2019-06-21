package com.codencolors.dagger2.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codencolors.dagger2.R;
import com.codencolors.dagger2.model.Article;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private Context context;
    private ArrayList<Article> articlesList;

    public NewsAdapter(Context context, ArrayList<Article> articlesList) {
        this.context = context;
        this.articlesList = articlesList;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_news, viewGroup, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder newsViewHolder, int i) {
        Article article = articlesList.get(i);
        newsViewHolder.lblTitle.setText(article.getTitle());
        newsViewHolder.lblSourceName.setText(article.getSource().getName());
        newsViewHolder.lblPublishedAt.setText(article.getPublishedAt());
    }

    @Override
    public int getItemCount() {
        return articlesList.size();
    }

    static class NewsViewHolder extends RecyclerView.ViewHolder {

        private TextView lblTitle;
        private TextView lblSourceName;
        private TextView lblPublishedAt;

        NewsViewHolder(@NonNull View itemView) {
            super(itemView);

            lblPublishedAt = itemView.findViewById(R.id.lbl_published_at);
            lblSourceName = itemView.findViewById(R.id.lbl_source_name);
            lblTitle = itemView.findViewById(R.id.lbl_title);
        }
    }
}
