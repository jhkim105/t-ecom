package com.tcacademy.ecommerce.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_user")
public class User implements Serializable {

  private static final long serialVersionUID = -4427406588176074887L;

  @Id
  @GeneratedValue
  private Long id;

  @Column(length = 30)
  private String name;

  @Column(length = 50)
  private String username;

  @Column(length = 20)
  private String password;

  @Column(length = 100)
  private String email;

  @Column(length = 12)
  private String mobile;

}
