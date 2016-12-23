package com.vinhomn.web.admin;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vinhomn.data.domain.Product;

@Controller
@RequestMapping("/admin/products")
public class ProductController {

    @GetMapping
    public Map<String, List<Product>> getList() {

        List<Product> products = new ArrayList<Product>();
        Map<String, List<Product>> modelMap = new HashMap<String, List<Product>>();
        modelMap.put("model", products);
        return modelMap;
    }
    
    @GetMapping("/create")
    public Model create(Model model) {
        Product product = new Product();
        product.setName("test");
        
        model.addAttribute("product", product);
        return model;
    }
    
    @PostMapping("/create")
    public String create(@Valid Product product, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "admin/products/create";
        }
        Timestamp now = new Timestamp(System.currentTimeMillis());
        
        product.setCreatedOn(now);
        product.setVariants(new HashSet<>());
        
        return "redirect:/admin/products";
    }
}
