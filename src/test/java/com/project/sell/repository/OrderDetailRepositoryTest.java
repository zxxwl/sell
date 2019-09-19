package com.project.sell.repository;

import com.project.sell.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {
    @Autowired
    private OrderDetailRepository repository;
    @Test
    public void saveTest(){
        OrderDetail orderDetail=new OrderDetail();
        orderDetail.setDetailId("123456789");
        orderDetail.setOrderId("11111");
        orderDetail.setProductIcon("http://xxx.jpg");
        orderDetail.setProductId("12323213");
        orderDetail.setProductName("麻辣香锅");
        orderDetail.setProductPrice(new BigDecimal(9.9));
        orderDetail.setProductQuantity(2);
        OrderDetail save = repository.save(orderDetail);
        Assert.assertNotNull(save);
    }
    @Test
    public void findByOrderId() {
        List<OrderDetail> byOrderId = repository.findByOrderId("11111");
        Assert.assertNotEquals(0,byOrderId.size());
    }
}