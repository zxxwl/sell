package com.project.sell.service.impl;

import com.project.sell.dataobject.ProductInfo;
import com.project.sell.enums.ProductStatusEnum;
import com.project.sell.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {
    @Autowired
    private ProductServiceImpl productService;
    @Test
    public void findOne() {
        Optional<ProductInfo> byId = productService.findById("8");
        System.out.println(byId);
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> upAll = productService.findUpAll();
        System.out.println(upAll.size());
    }

    @Test
    public void findAll() {
        PageRequest pageRequest = new PageRequest(0, 2);
        Page<ProductInfo> all = productService.findAll(pageRequest);
        System.out.println(all.getTotalElements());
    }

    @Test
    public void save() {
        ProductInfo productInfo=new ProductInfo();
        productInfo.setProductId("123");
        productInfo.setProductName("米线");
        productInfo.setProductPrice(new BigDecimal(7));
        productInfo.setProductStock(120);
        productInfo.setProductDescription("好吃哟不贵");
        productInfo.setProductIcon("www.haochi.jpg");
        productInfo.setCategoryType(11);
        productInfo.setProductStatus(0);
        ProductInfo save = productService.save(productInfo);
        System.out.println(save);
    }
}