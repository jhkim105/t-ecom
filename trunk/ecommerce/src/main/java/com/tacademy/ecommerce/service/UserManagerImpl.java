package com.tacademy.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tacademy.ecommerce.domain.User;
import com.tacademy.ecommerce.repository.UserRepository;

@Service
public class UserManagerImpl implements UserManager {

  @Autowired
  private UserRepository userRepository;

  @Override
  public boolean existUserByUsername(String username) {
    return findByUsername(username) != null;
  }

  @Override
  public User save(User user) {
    return userRepository.save(user);
  }

  @Override
  public User findByUsername(String username) {
    return userRepository.findByUsername(username);
  }

}
