package com.project.sell.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
    PRARM_ERROR(1,"参数不正确"),
    PRODUCT_NOT_EXIST(3,"商品不存在"),
    PRODUCT_STOCK_ERROR(7,"库存不足"),
    ORDER_NOT_EXIST(9,"订单不存在"),
    ORDERDETAIL_NOT_EXIST(10,"订单详情不存在"),
    ORDER_STATUS_ERROR(11,"订单状态不正确"),
    ORDER_UPDATE_FAIL(12,"订单更新失败"),
    ORDER_DETAIL_EMPTY(13,"订单详情为空"),
    ORDER_PAYSTATUS_ERROR(14,"订单支付状态不正确"),
    ORDER_PAYUPDATE_FAIL(15,"订单支付更新失败"),
    CART_EMPTY(16,"购物车不能为空"),
    ORDER_OWNER_ERROR(17,"该订单不属于当前用户"),
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
