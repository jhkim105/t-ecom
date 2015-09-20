package com.tacademy.ecommerce.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.constructor.BaseConstructor;

import com.tacademy.ecommerce.common.BaseController;
import com.tacademy.ecommerce.common.ResponseVO;
import com.tacademy.ecommerce.domain.Product;
import com.tacademy.ecommerce.domain.User;
import com.tacademy.ecommerce.service.ProductManager;

@RestController
@RequestMapping("/product")
public class ProductController extends BaseController {

  @Autowired
  private ProductManager productManager;

  @Autowired
  private Environment env;

  @RequestMapping(method = RequestMethod.GET)
  public ApiDataListResponseVO<Product> list(ApiDataListRequestVO requestVO) {

    Page<Product> page = productManager.findProducts(requestVO.getPageable());
    return new ApiDataListResponseVO<Product>(page);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ApiDataResponseVO<Product> detail(@PathVariable Long id) {

    Product product = productManager.findOne(id);
    return new ApiDataResponseVO<Product>(product);
  }

  @RequestMapping(value = "/{id}/comment", method = RequestMethod.POST)
  public ResponseVO addComment(@PathVariable Long id, @RequestParam String comment) {

    Long userId = getCurrentUser().getId();
    productManager.addComment(userId, id, comment);
    return ResponseVO.ok();
  }

  @RequestMapping(value = "/{id}/comment/{commentId}/delete", method = RequestMethod.POST)
  public ResponseVO deleteComment(@PathVariable Long id, @PathVariable Long commentId) {
    Long userId = getCurrentUser().getId();
    productManager.deleteComment(userId, id, commentId);
    return ResponseVO.ok();
  }

}
