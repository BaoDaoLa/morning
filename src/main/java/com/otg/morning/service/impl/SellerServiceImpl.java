package com.otg.morning.service.impl;

import com.otg.morning.entity.SellerInfo;
import com.otg.morning.repository.SellerInfoRepository;
import com.otg.morning.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by OTG on 2018/11/1.
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepository repository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return repository.findByOpenid(openid);
    }
}
