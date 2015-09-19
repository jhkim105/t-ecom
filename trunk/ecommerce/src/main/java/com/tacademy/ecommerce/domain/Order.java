package com.tacademy.ecommerce.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "t_order")
@Data
@EqualsAndHashCode(callSuper = false)
public class Order extends AbstractEntity<Long> {

  private static final long serialVersionUID = 3055545243080304581L;

  @Id
  @GeneratedValue
  private Long id;

  @Column(length = 30)
  private String name;

  @Column(name = "order_date")
  private Date orderDate;

  @Enumerated
  @Column(name = "order_status")
  private OrderStatus orderStatus;

  @Column(name = "order_price")
  private Double orderPrice;

  @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<OrderProduct> orderProducts = new HashSet<OrderProduct>();

  @ManyToOne
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  protected User user;

}
