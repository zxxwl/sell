package com.project.sell.converter;

import com.project.sell.dataobject.OrderMaster;
import com.project.sell.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName OrderMasterOrderDTOConverter
 * @AuthotAdministrator
 * @Date 2019/8/3 12:11
 **/
public class OrderMasterOrderDTOConverter {
    public static OrderDTO convert(OrderMaster orderMaster){
        OrderDTO orderDTO=new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }
    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList){
        return orderMasterList.stream().map(e ->convert(e)).collect(Collectors.toList());
    }
}
