package com.tacademy.ecommerce.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "t_authority")
@Data
@EqualsAndHashCode(callSuper = false)
public class Authority extends AbstractEntity<Long> implements GrantedAuthority {

  private static final long serialVersionUID = 5803434725021745049L;

  @Id
  @GeneratedValue
  private Long id;

  @Column(length = 30)
  private String authority;

}
