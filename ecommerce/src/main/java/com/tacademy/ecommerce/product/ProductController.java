package com.tacademy.ecommerce.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tacademy.ecommerce.common.ResponseVO;
import com.tacademy.ecommerce.service.ProductManager;
import com.tcacademy.ecommerce.domain.Product;

@Controller
@RequestMapping("/product")
@SessionAttributes("product")
public class ProductController {

  @Autowired
  private ProductManager productManager;

  @RequestMapping(method = RequestMethod.GET)
  public String list(Model model, Pageable pageable) {

    Page<Product> page = productManager.findProducts(pageable);
    model.addAttribute("page", page);
    return "product/list";
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public String form(@PathVariable Long id, Model model) {
    Product product = productManager.findOne(id);
    model.addAttribute("product", product);
    return "product/form";
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.POST)
  @ResponseBody
  public ResponseVO save(@ModelAttribute Product product) {

    productManager.save(product);
    return ResponseVO.ok();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  @ResponseBody
  public ResponseVO delete(@PathVariable Long id) {
    productManager.delete(id);
    return ResponseVO.ok();
  }

}
