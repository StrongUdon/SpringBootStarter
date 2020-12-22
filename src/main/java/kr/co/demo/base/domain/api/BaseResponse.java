package kr.co.demo.base.domain.api;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class BaseResponse<T> implements Serializable {

    private String status;
    private String apiName;
    private T ret;
}
