package com.tacademy.ecommerce.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

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
  @JsonProperty("orderId")
  private Long id;

  @Column(name = "order_date")
  private Date orderDate;

  @Enumerated(EnumType.STRING)
  @Column(name = "order_status", length = 12)
  @JsonProperty
  private OrderStatus orderStatus;

  @Enumerated(EnumType.STRING)
  @Column(name = "pay_method", length = 12)
  @JsonProperty
  private PayMethod payMethod;

  @Column(name = "order_price")
  @JsonProperty
  private Double orderPrice;

  @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonProperty
  private Set<OrderProduct> orderProducts = new HashSet<OrderProduct>();

  @ManyToOne
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  protected User user;

  @Column(name = "recipient_name", length = 30)
  @JsonProperty
  private String recipientName;

  @Column(name = "delivery_address", length = 255)
  @JsonProperty
  private String deliveryAddress;

  @Column(name = "recipient_tel", length = 15)
  @JsonProperty
  private String recipientTel;

  @JsonProperty("orderDate")
  public Long getOrderDateTimestamp() {
    return this.orderDate.getTime();
  }

}
