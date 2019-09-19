package com.project.sell.service.impl;

import com.project.sell.dataobject.OrderDetail;
import com.project.sell.dto.OrderDTO;
import com.project.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {
    @Autowired
    private OrderService orderService;

    private final String BUYER_OPEDID="110110";
    private final String ORDER_ID="156450768836813979";
    @Test
    public void createOrder() {
        OrderDTO orderDTO=new OrderDTO();
        orderDTO.setBuyerName("小李");
        orderDTO.setBuyerAddress("丽江");
        orderDTO.setBuyerOpenid(BUYER_OPEDID);
        orderDTO.setBuyerPhone("18713145213");
        //购物车
        List<OrderDetail> orderDetailList=new ArrayList<>();
        OrderDetail orderDetail=new OrderDetail();
        orderDetail.setProductId("123");
        orderDetail.setProductQuantity(1);
        orderDetailList.add(orderDetail);
        orderDTO.setOrderDetailList(orderDetailList);
        OrderDTO order = orderService.createOrder(orderDTO);
        log.info("【创建订单】 order={}",order);
    }
    @Test
    public void findOrder(){
        OrderDTO order = orderService.findOrder(ORDER_ID);
        System.out.println("order======"+order);
    }

    @Test
    public void findList() {
        PageRequest request=new PageRequest(0,2);
        Page<OrderDTO> orderDTOPage = orderService.findList(BUYER_OPEDID, request);
        Assert.assertNotEquals(0,orderDTOPage.getTotalElements());
    }

    @Test      //取消订单
    public void cancelOrder() {
        //判断订单状态
        OrderDTO orderDTO=orderService.findOrder(ORDER_ID);
        OrderDTO cancelOrder = orderService.cancelOrder(orderDTO);
        System.out.println("cancelOrder========"+cancelOrder);
    }

    @Test   //完结订单
    public void endOrder() {
        OrderDTO orderDTO=orderService.findOrder(ORDER_ID);
        OrderDTO endOrder = orderService.endOrder(orderDTO);
        System.out.println("endOrder======="+endOrder);
    }

    @Test   //订单支付
    public void payOrder() {
        OrderDTO orderDTO=orderService.findOrder(ORDER_ID);
        OrderDTO endOrder = orderService.payOrder(orderDTO);
        System.out.println("endOrder======="+endOrder);
    }
}