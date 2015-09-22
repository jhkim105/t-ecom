package com.tacademy.ecommerce.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tacademy.ecommerce.domain.CartProduct;

public interface CartManager {

  Page<CartProduct> getCartProducts(Long userId, Pageable pageable);

  void addProduct(Long userId, Long productId, Integer buyCount);

  void deleteProduct(Long userId, Long productId);

}