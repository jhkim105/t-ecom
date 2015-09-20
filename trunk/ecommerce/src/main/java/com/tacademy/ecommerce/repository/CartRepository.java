package com.tacademy.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.tacademy.ecommerce.domain.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>, QueryDslPredicateExecutor<Cart>, CartRepositoryCustom {

}
