package com.tacademy.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.tacademy.ecommerce.domain.ProductComment;

public interface ProductCommentRepository extends JpaRepository<ProductComment, Long>, QueryDslPredicateExecutor<ProductComment> {

}
