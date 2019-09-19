package com.project.sell.service;

import com.project.sell.dataobject.ProductCategory;

import java.util.List;
import java.util.Optional;

public interface CategroyService {
    Optional<ProductCategory> findById(Integer category);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
