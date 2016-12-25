package com.vinhomn.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.vinhomn.data.domain.Product;

@Repository
@RepositoryRestResource(path = "products.json")
public interface ProductRepository extends JpaRepository<Product, Long> {
    public List<Product> findByNameLike(String name);
}
