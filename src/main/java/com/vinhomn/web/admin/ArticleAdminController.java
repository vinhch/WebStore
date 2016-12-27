package com.vinhomn.web.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vinhomn.service.ArticleService;
import com.vinhomn.web.model.ArticleModel;

@Controller
@RequestMapping("/admin/articles")
public class ArticleAdminController {
    @Autowired
    private ArticleService articleService;
    
    @GetMapping
    public String getList(Model model) {
        model.addAttribute("articles", articleService.findAll());
        return "admin/articles/list";
    }
    
    @GetMapping("/{id}")
    public String edit(@PathVariable(value="id") long id, Model model) {
        model.addAttribute("articles", new ArticleModel(articleService.findOne(id)));
        return "admin/articles/edit";
    }
    
    @PostMapping("/{id}")
    public String edit(@PathVariable(value="id") long id, @Valid ArticleModel articleModel,
            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors())
            return "admin/products/edit";
        articleService.editFromModel(id, articleModel);
        return "/admin/products/edit";
    }
    
    @GetMapping("/create")
    public Model create(Model model) {
        ArticleModel articleModel = new ArticleModel();
        model.addAttribute("articleModel", articleModel);
        return model;
    }
    
    @PostMapping("/create")
    public String create(@Valid ArticleModel articleModel, BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors())
            return "admin/articles/create";
        articleService.saveFromModel(articleModel);
        return "redirect:/admin/articles";
    }
}
