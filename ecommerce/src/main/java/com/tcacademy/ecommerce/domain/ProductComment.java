package com.tcacademy.ecommerce.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "t_product_comment")
@Data
@EqualsAndHashCode(callSuper = false)
public class ProductComment extends AbstractEnitty<Long> {

  private static final long serialVersionUID = -5263974104854877073L;

  @Id
  @GeneratedValue
  private Long id;

  @ManyToOne
  private Product product;

  @ManyToOne
  private User user;

  @Lob
  private String comment;

}
