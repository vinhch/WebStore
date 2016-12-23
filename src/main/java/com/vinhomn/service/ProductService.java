package com.vinhomn.service;

import java.util.List;

import com.vinhomn.data.domain.Product;

public interface ProductService {
    public Product save(Product entity);
    public void delete(long id);
    public Product findOne(long id);
    public List<Product> findAll();
}
