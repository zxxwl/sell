package com.project.sell.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.project.sell.dataobject.OrderDetail;
import com.project.sell.dto.OrderDTO;
import com.project.sell.enums.ResultEnum;
import com.project.sell.exception.SellException;
import com.project.sell.form.OrderForm;
import lombok.extern.slf4j.Slf4j;
import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName OrderFormOrderDTOConverter
 * @AuthotAdministrator
 * @Date 2019/8/5 0:19
 **/
@Slf4j
public class OrderFormOrderDTOConverter {
    public static OrderDTO converter(OrderForm orderForm){
        Gson gson=new Gson();
        OrderDTO orderDTO=new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        List<OrderDetail> orderDetailList=new ArrayList<>();
        try {
            orderDetailList= gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>(){}.getType());
        }catch (Exception e){
            log.error("【对象转化】错误，string={}",orderForm.getItems());
            throw new SellException(ResultEnum.PRARM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }
}
