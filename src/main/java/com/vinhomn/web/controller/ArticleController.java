package com.vinhomn.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vinhomn.service.ArticleService;

@Controller
@RequestMapping("/articles")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    
    @GetMapping
    public String getList(Model model) {
        model.addAttribute("articles", articleService.findAll());
        return "/articles/list";
    }
    
    @GetMapping("/{id}")
    public String detail(@PathVariable(value="id") long id, Model model) {
        model.addAttribute("articles", articleService.findOne(id));
        return "/articles/detail";
    }
}
