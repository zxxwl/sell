package com.project.sell.service.impl;

import com.project.sell.dataobject.ProductCategory;
import com.project.sell.repository.ProductCategoryRepository;
import com.project.sell.service.CategroyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CategoryServiceImpl implements CategroyService{
    @Autowired
    private ProductCategoryRepository repository;
    @Override
    public Optional<ProductCategory> findById(Integer category) {
        return repository.findById(category);
    }
    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }
}
