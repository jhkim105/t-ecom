package com.tacademy.ecommerce.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tacademy.ecommerce.common.BaseController;

@Controller
public class LoginController extends BaseController {

  @RequestMapping(value = "/admin/login", method = RequestMethod.GET)
  public String login() {
    return "login";
  }

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String index() {
    return "redirect:/admin/login";
  }

}
