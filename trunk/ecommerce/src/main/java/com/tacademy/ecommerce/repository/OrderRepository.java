package com.tacademy.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.tacademy.ecommerce.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Long>, QueryDslPredicateExecutor<Order>, OrderRepositoryCustom {

}
