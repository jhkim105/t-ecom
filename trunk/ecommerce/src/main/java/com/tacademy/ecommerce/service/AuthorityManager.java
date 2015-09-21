package com.tacademy.ecommerce.service;

import com.tacademy.ecommerce.domain.Authority;

public interface AuthorityManager {

  Authority findByAuthority(String authority);

}
