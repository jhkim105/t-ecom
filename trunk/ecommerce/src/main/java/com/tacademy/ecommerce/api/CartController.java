package com.tacademy.ecommerce.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tacademy.ecommerce.service.CartManager;

@Controller
@RequestMapping("/cart")
public class CartController {

  @Autowired
  private CartManager cartManager;

  @Autowired
  private Environment env;

}
