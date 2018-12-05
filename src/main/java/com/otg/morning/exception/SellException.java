package com.otg.morning.exception;

import com.otg.morning.enums.ResultEnum;
import lombok.Getter;

/**
 * Created by OTG on 2018/11/18.
 */
@Getter
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code=resultEnum.getCode();
    }
    public SellException(Integer code,String message){
        super(message);
        this.code=code;
    }
}
