package com.tacademy.ecommerce.domain;

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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

@Entity
@Table(name = "t_cart_product")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false, of = { "id" })
@ToString(exclude = { "cart", "product" })
@NoArgsConstructor
public class CartProduct extends AbstractEntity<CartProduct.Id> {

  private static final long serialVersionUID = -4141906823920871722L;

  @EmbeddedId
  private Id id = new Id();

  @ManyToOne
  @MapsId("cartId")
  private Cart cart;

  @ManyToOne
  @MapsId("productId")
  @JsonProperty
  @JsonUnwrapped
  private Product product;

  @Column(name = "buy_count")
  @JsonProperty
  private Integer buyCount;

  public CartProduct(Cart cart, Product product) {
    this.id.cartId = cart.getId();
    this.id.productId = product.getId();
    this.cart = cart;
    this.product = product;
  }

  @Data
  @Embeddable
  public static class Id implements Serializable {

    private static final long serialVersionUID = 340765999204142798L;

    @Column(name = "cart_id")
    private Long cartId;

    @Column(name = "product_id")
    private Long productId;

  }

  @JsonProperty("createdDate")
  public Long getCreatedTimestamp() {
    if (this.createdDate == null)
      return null;
    return this.createdDate.getTime();
  }

}
