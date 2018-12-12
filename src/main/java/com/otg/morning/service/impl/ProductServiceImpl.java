package com.otg.morning.service.impl;

import com.otg.morning.dto.CartDTO;
import com.otg.morning.entity.ProductInfo;
import com.otg.morning.enums.ResultEnum;
import com.otg.morning.exception.SellException;
import com.otg.morning.service.ProductService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by OTG on 2018/11/17.
 */
@Service
@CacheConfig(cacheNames = "product")
public class ProductServiceImpl implements ProductService {

//    @Autowired
//    private ProductInfoRepository repository;

    @Override
    @Cacheable(key = "1234")
    public ProductInfo findOne(String productId) {
        return null;
    }

    @Override
    @CachePut(key = "1234")
    public ProductInfo save(ProductInfo productInfo) {
        return null;
    }
    /**
     * 查询所有在架商品列表
     * @return
     */
    @Override
    public List<ProductInfo> findUpAll() {
        return new ArrayList<>();
    }

    @Override

    public Page<ProductInfo> findAll(Pageable pageable) {
        return new PageImpl<>(new ArrayList<>());
    }

    @Override
    public void increaseStock(List<CartDTO> cartDTOList) {

        for(CartDTO cartDTO:cartDTOList){
            ProductInfo productInfo=null;
            if(productInfo==null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIT);
            }
            Integer result=productInfo.getProductStock()+cartDTO.getProductQuantity();
            productInfo.setProductStock(result);
//            repository.save(productInfo);
        }
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for(CartDTO cartDTO: cartDTOList){
            ProductInfo productInfo=null;
            if(productInfo==null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIT);
            }
            Integer result=productInfo.getProductStock()-cartDTO.getProductQuantity();
            if(result<0){
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);

        }

    }

    @Override
    public ProductInfo onSale(String productId) {
//        ProductInfo productInfo=null;
//        if(productInfo==null){
//            throw new SellException(ResultEnum.PRODUCT_NOT_EXIT);
//        }
//        if(productInfo.getProductStatusEnum()==ProductStatusEnum.UP){
//            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
//        }
//        //更新
//        productInfo.setProductStatus(ProductStatusEnum.UP.getCode());

        return null;
    }

    @Override
    public ProductInfo offSale(String productId) {
//        ProductInfo productInfo=repository.findOne(productId);
//        if(productInfo==null){
//            throw new SellException(ResultEnum.PRODUCT_NOT_EXIT);
//        }
//        if(productInfo.getProductStatusEnum()==ProductStatusEnum.DOWN){
//            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
//        }
//        //更新
//        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());

        return null;
    }
}
