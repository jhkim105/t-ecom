package com.tacademy.ecommerce.service;

import com.tacademy.ecommerce.domain.User;

public interface UserManager {

  boolean existUserByUsername(String username);

  User save(User user);

  User findByUsername(String username);

}
