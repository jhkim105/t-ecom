package com.tacademy.ecommerce.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.tacademy.ecommerce.domain.Order;
import com.tacademy.ecommerce.domain.OrderStatus;

public interface OrderRepository extends JpaRepository<Order, Long>, QueryDslPredicateExecutor<Order>, OrderRepositoryCustom {

  Page<Order> findByOrderByOrderDateDesc(Pageable pageable);

  Page<Order> findByOrderStatusOrderByOrderDateDesc(OrderStatus orderStatus, Pageable pageable);
}
