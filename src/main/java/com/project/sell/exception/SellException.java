package com.project.sell.exception;

import com.project.sell.enums.ResultEnum;

/**
 * @ClassName SellException
 * @AuthotAdministrator
 * @Date 2019/7/27 0:11
 **/
public class SellException extends RuntimeException{

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
    public SellException(Integer code,String message) {
        super(message);
        this.code = code;
    }
}
