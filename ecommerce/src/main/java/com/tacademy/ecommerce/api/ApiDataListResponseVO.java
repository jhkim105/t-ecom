package com.tacademy.ecommerce.api;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.springframework.data.domain.Page;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tacademy.ecommerce.common.ResponseVO;
import com.tacademy.ecommerce.common.ResultCodes;

@Getter
@Setter
@ToString
public class ApiDataListResponseVO<T extends Serializable> extends ResponseVO {

  private static final long serialVersionUID = -8702013692167568360L;

  @JsonProperty
  private List<T> list;

  @JsonProperty
  private int pageSize;

  @JsonProperty
  private Integer page;

  @JsonProperty
  private long fullListSize;

  public ApiDataListResponseVO(String resultCode) {
    super(resultCode);
  }

  public ApiDataListResponseVO(List<T> list) {
    this(ResultCodes.OK);
    this.list = list;
  }

  public ApiDataListResponseVO(Page<T> page) {
    this(ResultCodes.OK);
    this.list = page.getContent();
    this.pageSize = page.getSize();
    this.page = page.getNumber() + 1;
    this.fullListSize = page.getTotalElements();
  }

}
