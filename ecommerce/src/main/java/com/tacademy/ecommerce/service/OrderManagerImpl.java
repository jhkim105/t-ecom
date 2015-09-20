package com.tacademy.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tacademy.ecommerce.repository.OrderRepository;

@Service
public class OrderManagerImpl implements OrderManager {

  @Autowired
  private OrderRepository orderRepository;

}
