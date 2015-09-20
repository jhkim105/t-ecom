package com.tacademy.ecommerce.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tacademy.ecommerce.domain.Product;
import com.tacademy.ecommerce.service.ProductManager;

@RestController
@RequestMapping("/product")
public class ProductController {

  @Autowired
  private ProductManager productManager;

  @Autowired
  private Environment env;

  @RequestMapping(method = RequestMethod.GET)
  public ApiDataListResponseVO<Product> list(ApiDataListRequestVO requestVO) {

    Page<Product> page = productManager.findProducts(requestVO.getPageable());
    return new ApiDataListResponseVO<Product>(page);
  }

}
