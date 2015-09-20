package com.tacademy.ecommerce.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mysema.query.jpa.impl.JPAQuery;
import com.tacademy.ecommerce.domain.QUser;
import com.tacademy.ecommerce.domain.User;

public class UserRepositoryImpl implements UserRepositoryCustom {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public User findByUsername(String username) {

    JPAQuery query = new JPAQuery(entityManager);
    QUser user = QUser.user;
    query.from(user).where(user.username.eq(username));
    return query.singleResult(user);
  }

}
