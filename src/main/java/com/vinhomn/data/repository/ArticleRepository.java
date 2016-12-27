package com.vinhomn.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.vinhomn.data.domain.Article;

@Repository
@RepositoryRestResource(path = "articles.json")
public interface ArticleRepository extends JpaRepository<Article, Long> {
    public List<Article> findByTitleLike(String title);
}
