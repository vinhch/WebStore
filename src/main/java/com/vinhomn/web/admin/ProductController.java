package com.vinhomn.web.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vinhomn.service.ProductService;
import com.vinhomn.web.model.ProductModel;

@Controller
@RequestMapping("/admin/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    
    @GetMapping
    public Model getList(Model model) {

        model.addAttribute("products", productService.findAll());
        return model;
    }
    
    @GetMapping("/create")
    public Model create(Model model) {
        ProductModel productModel = new ProductModel();
        productModel.setName("test");
        
        model.addAttribute("productModel", productModel);
        return model;
    }
    
    @PostMapping("/create")
    public String create(@Valid ProductModel productModel, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "admin/products/create";
        }
        
        productService.saveFromModel(productModel);
        
        return "redirect:/admin/products";
    }
}
