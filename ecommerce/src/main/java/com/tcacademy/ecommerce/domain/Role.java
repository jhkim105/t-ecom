package com.tcacademy.ecommerce.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "t_role")
@Data
@EqualsAndHashCode(callSuper = false)
public class Role extends AbstractEnitty<Long> implements GrantedAuthority {

  private static final long serialVersionUID = 5803434725021745049L;

  @Id
  @GeneratedValue
  private Long id;

  @Column(length = 30)
  private String name;

  @Override
  public String getAuthority() {
    return this.name;
  }

}
