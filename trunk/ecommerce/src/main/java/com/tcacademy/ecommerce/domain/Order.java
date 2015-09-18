package com.tcacademy.ecommerce.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_order")
public class Order implements Serializable {

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
  
  @OneToMany(mappedBy = "gameCategory", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<OrderProduct> followGameCategories = new HashSet<OrderProduct>();


}
