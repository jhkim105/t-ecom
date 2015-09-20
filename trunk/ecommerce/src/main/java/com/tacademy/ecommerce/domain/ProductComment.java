package com.tacademy.ecommerce.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "t_product_comment")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false, of = { "id" })
@ToString
@NoArgsConstructor
public class ProductComment extends AbstractEntity<Long> {

  private static final long serialVersionUID = 2565700146595978236L;

  @Id
  @GeneratedValue
  @JsonProperty("commentId")
  private Long id;

  @ManyToOne(optional = false)
  private Product product;

  @ManyToOne(optional = false)
  private User user;

  @Lob
  @JsonProperty("comment")
  private String comment;

  public ProductComment(Product product, User user, String comment) {
    this.product = product;
    this.user = user;
    this.comment = comment;
  }

  @JsonProperty("userId")
  public Long getUserId() {
    return this.user.getId();
  }

  @JsonProperty("userName")
  public String getUserName() {
    return this.user.getName();
  }

  @JsonProperty("createdDate")
  public Long getCreatedTimestamp() {
    if (this.createdDate == null)
      return null;
    return this.createdDate.getTime();
  }

}
