package com.vinhomn.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinhomn.data.domain.Article;
import com.vinhomn.data.repository.ArticleRepository;
import com.vinhomn.service.ArticleService;
import com.vinhomn.web.model.ArticleModel;

@Service("articleService")
@Transactional
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public Article save(Article entity) {
        return articleRepository.save(entity);
    }

    @Override
    public void delete(long id) {
        articleRepository.delete(id);
    }

    @Override
    public Article findOne(long id) {
        return articleRepository.findOne(id);
    }

    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public Article saveFromModel(ArticleModel model) {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        
        Article entity = new Article();
        entity.setCreatedOn(now);
        entity.setTitle(model.getTitle());
        entity.setContent(model.getContent());
        
        return articleRepository.save(entity);
    }

    @Override
    public Article editFromModel(long id, ArticleModel model) {
        Article article = articleRepository.findOne(id);
        if (article == null) return null;
        
        Timestamp now = new Timestamp(System.currentTimeMillis());
        article.setTitle(model.getTitle());
        article.setContent(model.getContent());
        article.setModifiedOn(now);
        
        return article;
    }

}
