package com.project.sell.repository;

import com.project.sell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {

   List<ProductCategory> findByCategoryTypeIn(List<Integer> productCategory);


   //ProductCategory findProductCategoryBy(Integer id);
}
