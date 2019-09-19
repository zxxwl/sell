package com.project.sell.dto;

import lombok.Data;

/**
 * @ClassName CartDTO
 * @AuthotAdministrator
 * @Date 2019/7/28 1:20
 **/
@Data
public class CartDTO {
    /** 商品id */
    private String productId;
    /** 数量 */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }

    public CartDTO() {
    }
}
