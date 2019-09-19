package com.project.sell.service.impl;

import com.project.sell.dto.OrderDTO;
import com.project.sell.enums.ResultEnum;
import com.project.sell.exception.SellException;
import com.project.sell.service.BuyerService;
import com.project.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName BuyerServiceImpl
 * @AuthotAdministrator
 * @Date 2019/8/6 23:56
 **/
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService{
    @Autowired
    private OrderService orderService;
    @Override
    public OrderDTO findOrderOne(String openid,String orderId) {
        return checkOrderOwner(openid, orderId);
    }

    @Override
    public OrderDTO cancelOrderT(String openid,String orderId) {
        OrderDTO orderDTO = checkOrderOwner(openid, orderId);
        if (orderDTO==null){
            log.error("【取消订单】查询不到该订单,orderDTO={}",orderDTO);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderService.cancelOrder(orderDTO);
    }
    public OrderDTO checkOrderOwner(String openid,String orderId){
        OrderDTO orderDTO = orderService.findOrder(orderId);
        if(orderDTO==null){
            return null;
        }
        if (!orderDTO.getBuyerOpenid().equalsIgnoreCase(openid)){
            log.error("【查询单个订单】 订单openid不一致,openid={},orderDTO={}",openid,orderDTO);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }
}
