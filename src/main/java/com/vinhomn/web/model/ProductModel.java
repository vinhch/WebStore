package com.vinhomn.web.model;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.vinhomn.data.domain.Product;
import com.vinhomn.data.domain.Variant;

public class ProductModel {
    @Size(min=2, max=30)
    private String name;

    private String content;
    
    @NotNull
    @DecimalMin("0.01")
    private BigDecimal price;

    private Integer quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
    public ProductModel() { }
    public ProductModel(Product product){
        this.setName(product.getName());
        this.setContent(product.getContent());
        
        Variant variant = product.getVariants().stream().findFirst().get();
        this.setPrice(variant.getPrice());
        this.setQuantity(variant.getQuantity());
    }
}
