package com.tacademy.ecommerce.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

  @RequestMapping("/sbadmin")
  public String index() {
    return "sbadmin";
  }
}
