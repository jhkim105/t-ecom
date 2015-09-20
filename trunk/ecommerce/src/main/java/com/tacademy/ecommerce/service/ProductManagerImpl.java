package com.tacademy.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tacademy.ecommerce.domain.Product;
import com.tacademy.ecommerce.domain.ProductComment;
import com.tacademy.ecommerce.domain.User;
import com.tacademy.ecommerce.repository.ProductCommentRepository;
import com.tacademy.ecommerce.repository.ProductRepository;
import com.tacademy.ecommerce.repository.UserRepository;

@Service
public class ProductManagerImpl implements ProductManager {

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private ProductCommentRepository productCommentRepository;

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
  public void addComment(Long userId, Long id, String comment) {

    // 관계에 의한 저장 샘플
    Product product = findOne(id);
    User user = userRepository.findOne(userId);
    ProductComment productComment = new ProductComment(product, user, comment);
    product.getProductComments().add(productComment);
  }

  @Override
  @Transactional
  public void deleteComment(Long userId, Long id, Long commentId) {

    // 관계에 의한 삭제가 아닌 직접 삭제 샘플
    ProductComment productComment = productCommentRepository.findOne(commentId);
    if (productComment.getUserId() != userId || productComment.getProduct().getId() != id)
      throw new RuntimeException("커멘트를 삭제할 수 없습니다.");

    productCommentRepository.delete(commentId);
  }
}
