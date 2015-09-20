package com.tacademy.ecommerce.api;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.tacademy.ecommerce.common.ResponseVO;
import com.tacademy.ecommerce.common.ResultCodes;

@Getter
@Setter
public class ApiDataResponseVO<T extends Serializable> extends ResponseVO {

  private static final long serialVersionUID = 2718902523399739315L;

  @JsonUnwrapped
  private T data;

  public ApiDataResponseVO(String resultCode) {
    super(resultCode);
  }

  public ApiDataResponseVO(T data) {
    this(ResultCodes.OK);
    this.data = data;
  }

}
