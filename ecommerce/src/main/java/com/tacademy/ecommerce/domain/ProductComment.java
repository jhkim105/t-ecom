package com.tacademy.ecommerce.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "t_product_comment")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false, of = { "id" })
@ToString
public class ProductComment extends AbstractEntity<Long> {

  private static final long serialVersionUID = 2565700146595978236L;

  @Id
  @GeneratedValue
  @JsonProperty
  private Long id;

  @ManyToOne(optional = false)
  private Product product;

  @ManyToOne(optional = false)
  private User user;

  @Lob
  private String comment;

}
