package com.tacademy.ecommerce.common;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
@ToString
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude(value = Include.ALWAYS)
public class ResponseVO implements Serializable {

  private static final long serialVersionUID = -9136245193906832320L;

  @JsonProperty
  private String resultCode;

  @JsonProperty
  private String message;

  public ResponseVO(String resultCode) {
    this.resultCode = resultCode;
  }

  public ResponseVO(String resultCode, String message) {
    this.resultCode = resultCode;
    this.message = message;
  }

  public static ResponseVO ok() {
    return new ResponseVO(ResultCodes.OK);
  }

}
