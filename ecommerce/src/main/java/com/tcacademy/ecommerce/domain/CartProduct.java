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
@Table(name = "t_cart_product")
@Data
@EqualsAndHashCode(callSuper = false)
public class CartProduct extends AbstractEntity<CartProduct.Id> {

  private static final long serialVersionUID = -4141906823920871722L;

  @EmbeddedId
  private Id id = new Id();

  @ManyToOne
  @MapsId("cartId")
  private Cart cart;

  @ManyToOne
  @MapsId("productId")
  private Product product;

  @Data
  @Embeddable
  public static class Id implements Serializable {

    private static final long serialVersionUID = 340765999204142798L;

    @Column(name = "cart_id")
    private Long cartId;

    @Column(name = "product_id")
    private Long productId;

  }

}
