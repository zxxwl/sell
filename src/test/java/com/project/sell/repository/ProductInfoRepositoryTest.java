package com.project.sell.repository;

import com.project.sell.dataobject.ProductCategory;
import com.project.sell.dataobject.ProductInfo;
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
public class ProductInfoRepositoryTest {
    @Autowired
    private ProductInfoRepository repository;
    @Test
    public void findbyProductStatus() {
        List<ProductInfo> byProductStatus = repository.findByProductStatus(0);
        System.out.println(byProductStatus);
    }
    @Test
    public void test(){
        ProductInfo byId = repository.findByProductId(1);
        System.out.println(byId);
    }
    @Test
    public void saveTest(){
        ProductInfo productInfo=new ProductInfo();
        productInfo.setProductName("米痞子");
        productInfo.setProductPrice(new BigDecimal(5));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("好吃哟不贵");
        productInfo.setProductIcon("www.haokan.jpg");
        productInfo.setCategoryType(6);
        productInfo.setProductStatus(0);
        ProductInfo save = repository.save(productInfo);
        System.out.println(save);
    }
}