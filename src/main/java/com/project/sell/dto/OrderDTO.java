package com.project.sell.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.project.sell.dataobject.OrderDetail;
import com.project.sell.enums.OrderStatusEnum;
import com.project.sell.enums.PayStatusEnum;
import com.project.sell.utils.serializer.DateLongSerializer;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @ClassName OrderDTO
 * @AuthotAdministrator
 * @Date 2019/7/26 23:50
 **/
@Data
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
    /** 订单id */
    private String OrderId;
    /** 买家名字 */
    private String buyerName;
    /** 买家手机号 */
    private String buyerPhone;
    /** 买家地址 */
    private String buyerAddress;
    /** 买家微信openid */
    private String buyerOpenid;
    /** 订单总金额 */
    private BigDecimal orderAmount;
    /** 订单状态，默认为新下单 */
    private Integer orderStatus= OrderStatusEnum.NEW.getCode();
    /** 支付状态，默认为0未支付 */
    private Integer payStatus;
    /** 创建时间 */
    @JsonSerialize(using = DateLongSerializer.class)
    private Date createTime;
    /** 更新时间 */
    @JsonSerialize(using = DateLongSerializer.class)
    private Date updateTime;

    List<OrderDetail> orderDetailList;
}
