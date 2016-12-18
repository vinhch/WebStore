package com.vinhomn.data.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vinhomn.data.domain.Product;

@Transactional
public interface ProductRepository extends JpaRepository<Product, Long> {

	public List<Product> findByNameLike(String name);
}
