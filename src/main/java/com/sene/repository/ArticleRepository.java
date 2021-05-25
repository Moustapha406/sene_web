package com.sene.repository;

import com.sene.entities.Article;

import java.util.List;

public interface ArticleRepository {
    public Article addArticle(Article article, int id);
    public Article[] getAll();
    public Article getArticle(int id);
    public Article updateArticle(Article article);
    public void deleteArticle(int id);


}
