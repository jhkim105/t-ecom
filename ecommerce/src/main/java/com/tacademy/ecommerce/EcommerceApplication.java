package com.tacademy.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;

import com.tcacademy.ecommerce.domain.AbstractEntity;

@SpringBootApplication
@EntityScan(basePackageClasses = AbstractEntity.class)
public class EcommerceApplication {

  public static void main(String[] args) {
    SpringApplication.run(EcommerceApplication.class, args);
  }
}
