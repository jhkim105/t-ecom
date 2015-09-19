package com.tacademy.ecommerce.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.tacademy.ecommerce.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long>, QueryDslPredicateExecutor<Product> {

  Page<Product> findByOrderByCreatedDateDesc(Pageable pageable);
}
