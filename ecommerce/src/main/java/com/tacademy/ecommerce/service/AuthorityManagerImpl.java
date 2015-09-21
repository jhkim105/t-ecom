package com.tacademy.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tacademy.ecommerce.domain.Authority;
import com.tacademy.ecommerce.repository.AuthorityRepository;

@Service
public class AuthorityManagerImpl implements AuthorityManager {

  @Autowired
  private AuthorityRepository authorityRepository;

  @Override
  public Authority findByAuthority(String authority) {
    return authorityRepository.findByAuthority(authority);
  }

}
