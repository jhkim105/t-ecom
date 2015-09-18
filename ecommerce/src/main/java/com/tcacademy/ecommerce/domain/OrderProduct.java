package com.tcacademy.ecommerce.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_order_product")
public class OrderProduct implements Serializable {

  private static final long serialVersionUID = 8179212195644166901L;

  @EmbeddedId
  private Id id = new Id();

  @ManyToOne
  @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
  private User user;

  @ManyToOne
  @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
  private Product product;

  @Embeddable
  public static class Id implements Serializable {

    private static final long serialVersionUID = 226636815858337409L;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "product_id")
    private Long productId;

  }

}
