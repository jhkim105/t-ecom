package com.tacademy.ecommerce.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tacademy.ecommerce.service.OrderManager;

@RestController
@RequestMapping("/order")
public class OrderController {

  @Autowired
  private OrderManager orderManager;

  @Autowired
  private Environment env;


}
