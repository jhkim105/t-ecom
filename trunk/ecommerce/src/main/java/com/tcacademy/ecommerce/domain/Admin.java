package com.tcacademy.ecommerce.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_admin")
public class Admin implements Serializable {

  private static final long serialVersionUID = -1330170013092560680L;

  @Id
  @GeneratedValue
  private Long id;

  @Column(length = 30)
  private String name;

  @Column(length = 50)
  private String username;

  @Column(length = 20)
  private String password;


}
