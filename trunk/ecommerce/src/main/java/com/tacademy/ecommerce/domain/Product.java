package com.tacademy.ecommerce.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tacademy.ecommerce.config.SystemPropertiesConfig;

@Entity
@Table(name = "t_product")
@Data
@EqualsAndHashCode(callSuper = false)
public class Product extends AbstractEntity<Long> {

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

  @JsonProperty("imageUrl")
  public String getImageUrl() {
    return String.format("%s/product/%d/%s", System.getProperty(SystemPropertiesConfig.STORAGE_URI), this.id, this.imageFileName);
  }

  @Transient
  public String getImageUploadPath() {
    return String.format("%s/product/%d", System.getProperty(SystemPropertiesConfig.STORAGE_PATH), this.id);
  }

}
