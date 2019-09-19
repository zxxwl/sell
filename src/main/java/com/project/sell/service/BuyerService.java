package com.project.sell.service;

import com.project.sell.dto.OrderDTO;

public interface BuyerService {
    //查询一个订单
    OrderDTO findOrderOne(String openid,String orderId);
    //取消订单
    OrderDTO cancelOrderT(String openid,String orderId);
}
