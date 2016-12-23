package com.vinhomn.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinhomn.data.domain.Variant;

public interface VariantRepository extends JpaRepository<Variant, Long> {
    public List<Variant> findByProductIdAndTitleLike(long productId, String title);
}
