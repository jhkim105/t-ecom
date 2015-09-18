package com.tcacademy.ecommerce.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "t_product")
public class Product implements Serializable {

  private static final long serialVersionUID = 7568237900551155743L;

  @Id
  @GeneratedValue
  private Long id;

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
