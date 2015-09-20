package com.tacademy.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tacademy.ecommerce.domain.Product;
import com.tacademy.ecommerce.domain.User;
import com.tacademy.ecommerce.repository.ProductRepository;

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
  @Transactional
  public Product save(Product product) {
    return productRepository.save(product);
  }

  @Override
  @Transactional
  public void delete(Long id) {
    productRepository.delete(id);
  }

  @Override
  @Transactional
  public void addComment(User user, Long id, String comment) {
    Product product = findOne(id);
  }
}
