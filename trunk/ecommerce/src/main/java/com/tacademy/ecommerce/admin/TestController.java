package com.tacademy.ecommerce.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

  @RequestMapping("/sbadmin")
  public String sbadmin() {
    return "sbadmin";
  }
}
