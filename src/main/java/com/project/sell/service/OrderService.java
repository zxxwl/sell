package com.project.sell.service;

import com.project.sell.dataobject.OrderMaster;
import com.project.sell.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderService {

    /**  创建订单  */
    OrderDTO createOrder(OrderDTO orderDTO);
    /**  查询单个订单   */
    OrderDTO findOrder(String orderId);
    /**  查询订单列表   */
   Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);
    /**  取消订单   */
    OrderDTO cancelOrder(OrderDTO orderDTO);
    /**  完结订单   */
    OrderDTO endOrder(OrderDTO orderDTO);
    /**  支付订单   */
    OrderDTO payOrder(OrderDTO orderDTO);
}
