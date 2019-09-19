package com.project.sell.service;

import com.project.sell.dataobject.ProductInfo;
import com.project.sell.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * @ClassName ProductService
 * @AuthotAdministrator
 * @Date 2019/7/16 21:08
 **/
public interface ProductService {

    Optional<ProductInfo> findById(String productId);
    //查询所有在架商品列表
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //加库存
    void addStock(List<CartDTO> cartDTOList);

    //减库存
    void subtrackStock(List<CartDTO> cartDTOList);
}
