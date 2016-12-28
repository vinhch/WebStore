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

import com.vinhomn.service.ProductService;
import com.vinhomn.web.model.ProductModel;

@Controller
@RequestMapping("/admin/products")
public class ProductAdminController {
    @Autowired
    private ProductService productService;
    
    @GetMapping
    public String getList(Model model) {
        model.addAttribute("products", productService.findAll());
        return "/admin/products/list";
    }
    
    @GetMapping("/{id}")
    public String edit(@PathVariable(value="id") long id, Model model) {
        model.addAttribute("productModel", new ProductModel(productService.findOne(id)));
        return "/admin/products/edit";
    }
    
    @PostMapping("/{id}")
    public String edit(@PathVariable(value="id") long id, @Valid ProductModel productModel,
            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "admin/products/edit";
        }
        productService.editFromModel(id, productModel);
        return "/admin/products/edit";
    }
    
    @GetMapping("/create")
    public Model create(Model model) {
        ProductModel productModel = new ProductModel();
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
