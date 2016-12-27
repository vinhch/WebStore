package com.vinhomn.service;

import java.util.List;

import com.vinhomn.data.domain.Article;
import com.vinhomn.web.model.ArticleModel;

public interface ArticleService {
    public Article save(Article entity);
    public void delete(long id);
    public Article findOne(long id);
    public List<Article> findAll();
    
    public Article saveFromModel(ArticleModel model);
    public Article editFromModel(long id, ArticleModel model);
}
