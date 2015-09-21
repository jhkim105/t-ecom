package com.tacademy.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tacademy.ecommerce.domain.Role;
import com.tacademy.ecommerce.repository.RoleRepository;

@Service
public class RoleManagerImpl implements RoleManager {

  @Autowired
  private RoleRepository roleRepository;

  @Override
  public Role findByName(String rolename) {
    return roleRepository.findByName(rolename);
  }

}
