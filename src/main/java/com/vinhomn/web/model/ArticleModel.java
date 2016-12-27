package com.vinhomn.web.model;

import javax.validation.constraints.Size;

import com.vinhomn.data.domain.Article;

public class ArticleModel {
    @Size(min=2, max=255)
    private String title;
    
    private String content;

    public ArticleModel() { }
    public ArticleModel(Article article) {
        this.setTitle(article.getTitle());
        this.setContent(article.getContent());
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
