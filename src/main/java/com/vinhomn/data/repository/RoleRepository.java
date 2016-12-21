package com.vinhomn.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vinhomn.data.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Short> {
	public Role findById(short id);
	public Role findByCode(String code);
}
