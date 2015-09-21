package com.tacademy.ecommerce.admin;

import lombok.extern.apachecommons.CommonsLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tacademy.ecommerce.common.ResponseVO;
import com.tacademy.ecommerce.domain.Order;
import com.tacademy.ecommerce.domain.OrderStatus;
import com.tacademy.ecommerce.service.OrderManager;

@Controller("adminOrderController")
@RequestMapping("/admin/order")
@SessionAttributes("order")
@CommonsLog
public class OrderController {

  @Autowired
  private OrderManager orderManager;

  @Autowired
  private Environment env;

  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String list(Model model, Pageable pageable) {

    log.debug("pageNumber:" + pageable.getPageNumber() + ",pageSize:" + pageable.getPageSize());

    Page<Order> page = orderManager.getOrders(pageable);
    model.addAttribute("page", page);
    return "order/list";
  }

  @RequestMapping(value = "/cancel_list", method = RequestMethod.GET)
  public String cancelList(Model model, Pageable pageable) {

    Page<Order> page = orderManager.getOrdersByOrderStatus(OrderStatus.CANCELED, pageable);
    model.addAttribute("page", page);
    return "order/list";
  }

  @RequestMapping(value = "/view", method = RequestMethod.GET)
  public String view(@RequestParam Long id, Model model) {
    Order order = orderManager.findOne(id);
    model.addAttribute("order", order);
    model.addAttribute("orderStatuses", OrderStatus.values());
    return "order/form";
  }

  @RequestMapping(value = "/save", method = RequestMethod.POST)
  @ResponseBody
  public ResponseVO save(@ModelAttribute Order order) {
    orderManager.save(order);
    return ResponseVO.ok();
  }

}
