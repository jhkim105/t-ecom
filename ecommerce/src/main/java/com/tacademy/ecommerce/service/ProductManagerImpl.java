package com.tacademy.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tacademy.ecommerce.repository.ProductRepository;
import com.tcacademy.ecommerce.domain.Product;

@Service
public class ProductManagerImpl implements ProductManager {

  @Autowired
  private ProductRepository productRepository;

  @Override
  public Page<Product> findProducts(Pageable pageable) {
    return productRepository.findByOrderByCreatedDateDesc(pageable);
  }

  @Override
  public Product findOne(Long id) {
    return productRepository.findOne(id);
  }

  @Override
  public void save(Product product) {
    productRepository.save(product);
  }

  @Override
  public void delete(Long id) {
    productRepository.delete(id);
  }

}
