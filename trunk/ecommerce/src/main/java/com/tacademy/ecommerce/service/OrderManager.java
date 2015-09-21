package com.tacademy.ecommerce.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tacademy.ecommerce.api.OrderRequestVO;
import com.tacademy.ecommerce.domain.Order;
import com.tacademy.ecommerce.domain.OrderStatus;
import com.tacademy.ecommerce.domain.User;

public interface OrderManager {

  Page<Order> getOrders(Long userId, Pageable pageable);

  Order findOne(Long id);

  void order(User currentUser, OrderRequestVO requestVO);

  void cancel(User currentUser, Long id);

  Page<Order> getOrders(Pageable pageable);

  Order save(Order order);

  Page<Order> getOrdersByOrderStatus(OrderStatus orderStatus, Pageable pageable);

}
