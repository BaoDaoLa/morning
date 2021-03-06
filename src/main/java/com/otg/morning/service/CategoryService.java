package com.otg.morning.service;

import com.otg.morning.entity.ProductCategory;

import java.util.List;

/**
 * Created by OTG on 2018/11/17.
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);

}
