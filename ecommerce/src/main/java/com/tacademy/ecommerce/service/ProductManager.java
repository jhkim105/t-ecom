package com.tacademy.ecommerce.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tacademy.ecommerce.domain.Product;

public interface ProductManager {

  Page<Product> findProducts(Pageable pageable);

  Product findOne(Long id);

  void save(Product product);

  void delete(Long id);

}
