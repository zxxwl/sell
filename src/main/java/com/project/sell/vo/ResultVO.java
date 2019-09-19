package com.project.sell.vo;

import lombok.Data;

/**
 * @ClassName ResultVO
 * @AuthotAdministrator
 * @Date 2019/7/16 22:48
 **/
@Data
public class ResultVO<T> {
    private Integer code;

    private String msg;

    private T data;
}
