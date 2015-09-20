package com.tacademy.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tacademy.ecommerce.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
