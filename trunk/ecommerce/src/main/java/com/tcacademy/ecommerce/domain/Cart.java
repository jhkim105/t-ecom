package com.tcacademy.ecommerce.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "t_cart")
@Data
@EqualsAndHashCode(callSuper = false)
public class Cart extends AbstractEntity<Long> {

  private static final long serialVersionUID = 7568237900551155743L;

  @Id
  private Long id;

  @OneToOne(optional = false)
  @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
  private User user;

  @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<CartProduct> cartProducts = new HashSet<CartProduct>();

  @Column(length = 30)
  private String name;

  @Column
  private Double price;

  @Column(name = "image_file_name", length = 100)
  private String imageFileName;

  @Column(length = 10)
  private String color;

  @Lob
  private String description;

}
