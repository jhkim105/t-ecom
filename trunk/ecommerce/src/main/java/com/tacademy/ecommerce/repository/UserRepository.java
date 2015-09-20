package com.tacademy.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.tacademy.ecommerce.domain.User;

public interface UserRepository extends JpaRepository<User, Long>, QueryDslPredicateExecutor<User>, UserRepositoryCustom {

}
