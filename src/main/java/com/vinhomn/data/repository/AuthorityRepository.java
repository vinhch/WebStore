package com.vinhomn.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vinhomn.data.domain.Authority;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Short> {
    public Authority findOneByCode(String code);
}
