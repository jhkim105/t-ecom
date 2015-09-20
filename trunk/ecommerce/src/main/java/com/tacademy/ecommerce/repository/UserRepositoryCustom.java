package com.tacademy.ecommerce.repository;

import com.tacademy.ecommerce.domain.User;

public interface UserRepositoryCustom {

  User findByUsername(String username);
}
