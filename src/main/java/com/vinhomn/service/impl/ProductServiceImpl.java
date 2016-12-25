package com.vinhomn.service.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinhomn.data.domain.Product;
import com.vinhomn.data.domain.Variant;
import com.vinhomn.data.repository.ProductRepository;
import com.vinhomn.service.ProductService;
import com.vinhomn.web.model.ProductModel;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    
    @Override
    public Product save(Product entity) {
        return productRepository.save(entity);
    }

    @Override
    public void delete(long id) {
        productRepository.delete(id);
    }

    @Override
    public Product findOne(long id) {
        return productRepository.findOne(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product saveFromModel(ProductModel model) {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        
        Product entity = new Product();
        entity.setCreatedOn(now);
        entity.setName(model.getName());
        entity.setContent(model.getContent());
        entity.addVariant(createDefaultProductVariant(model.getPrice()));
        
        return productRepository.save(entity);
    }
    
    private static Variant createDefaultProductVariant(BigDecimal price) {
        Variant variant = new Variant();
        variant.setTitle("Default title");
        variant.setPrice(price);
        
        return variant;
    }
}
