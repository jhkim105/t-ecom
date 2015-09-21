package com.tacademy.ecommerce.service;

import com.tacademy.ecommerce.domain.Role;

public interface RoleManager {

  Role findByName(String rolename);


}
