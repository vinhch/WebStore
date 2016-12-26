package com.vinhomn.service;

import java.util.List;

import com.vinhomn.data.domain.Product;
import com.vinhomn.web.model.ProductModel;

public interface ProductService {
    public Product save(Product entity);
    public void delete(long id);
    public Product findOne(long id);
    public List<Product> findAll();
    
    public Product saveFromModel(ProductModel model);
    public Product editFromModel(long id, ProductModel model);
}
