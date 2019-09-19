package com.project.sell.repository;

import com.project.sell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest()
public class OrderMatserRepositoryTest {
    @Autowired
    private OrderMatserRepository repository;

    private final String OPENID="110120";
    @Test
    public void saveTest(){
        OrderMaster orderMaster=new OrderMaster();
        orderMaster.setOrderId("12345");
        orderMaster.setBuyerName("七七");
        orderMaster.setBuyerPhone("18943638279");
        orderMaster.setBuyerAddress("成都市青羊区少林路");
        orderMaster.setBuyerOpenid("110120");
        orderMaster.setOrderAmount(new BigDecimal(9.9));
        OrderMaster save = repository.save(orderMaster);
        Assert.assertNotNull(save);
    }
    @Test
    public void findByBuyerOpenid() {
        Pageable request=new PageRequest(0,1);
        Page<OrderMaster> byBuyerOpenid = repository.findByBuyerOpenid(OPENID, request);
        System.out.println(byBuyerOpenid.getTotalElements());
    }
}