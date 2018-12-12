package com.otg.morning.service.impl;

import com.otg.morning.entity.ProductCategory;
import com.otg.morning.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by OTG on 2018/11/17.
 */
@Service
public class CategoryServiceImpl implements CategoryService{

//    @Autowired
//    private ProductCategoryRepository repository;
    @Override
    public ProductCategory findOne(Integer categoryId) {
        return null;
    }

    @Override
    public List<ProductCategory> findAll() {
        return new ArrayList<>();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return new ArrayList<>();
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return null;
    }
}
