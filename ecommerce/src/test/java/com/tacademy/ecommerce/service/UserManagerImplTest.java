package com.tacademy.ecommerce.service;

import java.util.Arrays;

import lombok.extern.apachecommons.CommonsLog;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tacademy.ecommerce.EcommerceApplication;
import com.tacademy.ecommerce.api.OrderRequestVO;
import com.tacademy.ecommerce.api.OrderRequestVO.Data;
import com.tacademy.ecommerce.domain.PayMethod;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = EcommerceApplication.class)
@WebAppConfiguration
@CommonsLog
public class UserManagerImplTest extends AbstractTransactionalJUnit4SpringContextTests {

  @Autowired
  private UserManager userManager;

  @Test
  public void testFindByUsername() throws Exception {
    log.debug(userManager.findByUsername("user01"));
  }

  @Test
  public void testtest() {
    OrderRequestVO requestVO = new OrderRequestVO();
    requestVO.setDeliveryAddress("dd");
    requestVO.setPayMethod(PayMethod.CARD);
    requestVO.setOrderPrice(1000d);
    requestVO.setRecipientName("홍길동");
    requestVO.setRecipientTel("011-222-3333");
    requestVO.setOrderList(Arrays.asList(new Data(1L, 10), new Data(2L, 12)));
    log.debug(toJsonString(requestVO));

  }

  public static String toJsonString(Object obj) {
    ObjectMapper mapper = new ObjectMapper();
    String result = "";
    try {
      result = mapper.writeValueAsString(obj);
    } catch (Exception e) {
      throw new RuntimeException(String.format("object convert to json string error..,%s", e.toString(), e));
    }
    return result;
  }

}
