package com.tacademy.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tacademy.ecommerce.repository.CartRepository;

@Service
public class CartManagerImpl implements CartManager {

  @Autowired
  private CartRepository cartRepository;

}
