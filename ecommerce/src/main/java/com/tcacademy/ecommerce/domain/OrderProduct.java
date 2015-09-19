package com.tcacademy.ecommerce.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "t_order_product")
@Data
@EqualsAndHashCode(callSuper = false)
public class OrderProduct extends AbstractEntity<OrderProduct.Id> {

  private static final long serialVersionUID = 8179212195644166901L;

  @EmbeddedId
  private Id id = new Id();

  @ManyToOne
  @MapsId("orderId")
  private Order order;

  @ManyToOne
  @MapsId("productId")
  private Product product;

  @Embeddable
  public static class Id implements Serializable {

    private static final long serialVersionUID = 226636815858337409L;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "product_id")
    private Long productId;

  }

}
