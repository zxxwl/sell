package com.project.sell.repository;

import com.project.sell.dataobject.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository repository;
    @Test
    public void findOneTest(){
        Optional<ProductCategory> by = repository.findById(1);
        System.out.println(by);
    }
    @Test
    public void saveTest(){
        ProductCategory productCategory=new ProductCategory("女生最爱",5);
        repository.save(productCategory);
    }
    @Test
    public void findByCategoryTypeInTest(){
        List list=Arrays.asList(1,2);
        List byCategoryTypeIn = repository.findByCategoryTypeIn(list);
        System.out.println("byCategoryTypeIn==="+byCategoryTypeIn);
    }
}