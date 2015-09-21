package com.tacademy.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.tacademy.ecommerce.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long>, QueryDslPredicateExecutor<Role> {

  Role findByName(String name);
}
