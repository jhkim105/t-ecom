package com.tacademy.ecommerce.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tacademy.ecommerce.common.BaseController;
import com.tacademy.ecommerce.common.ResponseVO;
import com.tacademy.ecommerce.domain.CartProduct;
import com.tacademy.ecommerce.service.CartManager;

@RestController
@RequestMapping("/cart")
public class CartController extends BaseController {

  @Autowired
  private CartManager cartManager;

  @RequestMapping(method = RequestMethod.GET)
  public ApiDataListResponseVO<CartProduct> list(ApiDataListRequestVO requestVO) {
    Long userId = getCurrentUser().getId();
    Page<CartProduct> page = cartManager.getCartProducts(userId, requestVO.getPageable());
    return new ApiDataListResponseVO<CartProduct>(page);
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseVO addProduct(@RequestParam(value = "id") Long productId, @RequestParam Integer buyCount) {
    Long userId = getCurrentUser().getId();
    cartManager.addProduct(userId, productId, buyCount);
    return ResponseVO.ok();
  }

  @RequestMapping(value = "/product/{id}/delete", method = RequestMethod.POST)
  public ResponseVO deleteProduct(@PathVariable Long id) {
    Long userId = getCurrentUser().getId();
    cartManager.deleteProduct(userId, id);
    return ResponseVO.ok();
  }

}
