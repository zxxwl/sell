package com.project.sell.service.impl;

import com.project.sell.dataobject.ProductInfo;
import com.project.sell.dto.CartDTO;
import com.project.sell.enums.ProductStatusEnum;
import com.project.sell.enums.ResultEnum;
import com.project.sell.exception.SellException;
import com.project.sell.repository.ProductInfoRepository;
import com.project.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @ClassName ProductServiceImpl
 * @AuthotAdministrator
 * @Date 2019/7/16 21:08
 **/
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoRepository repository;
    @Override
    public Optional<ProductInfo> findById(String productId) {
        return repository.findById(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public  Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    @Transactional
    public void addStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO:cartDTOList){
            Optional<ProductInfo> productInfo = repository.findById(cartDTO.getProductId());
            if (productInfo==null){
                throw  new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            int result= productInfo.get().getProductStock()+cartDTO.getProductQuantity();
            productInfo.get().setProductStock(result);
            repository.save(productInfo.get());
        }
    }

    @Override
    @Transactional
    public void subtrackStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO:cartDTOList){
            Optional<ProductInfo> productInfo = repository.findById(cartDTO.getProductId());
            if (productInfo==null){
                throw  new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            int result= productInfo.get().getProductStock()-cartDTO.getProductQuantity();
            if (result<0){
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.get().setProductStock(result);
            repository.save(productInfo.get());
        }
    }
}
