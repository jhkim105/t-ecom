package com.tacademy.ecommerce.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "t_cart")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false, of = { "id" })
@ToString(exclude = { "user" })
public class Cart extends AbstractEntity<Long> {

  private static final long serialVersionUID = 7568237900551155743L;

  @Id
  private Long id;

  @OneToOne(optional = false)
  @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
  private User user;

  @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<CartProduct> cartProducts = new HashSet<CartProduct>();

}
