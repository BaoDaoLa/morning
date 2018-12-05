package com.otg.morning.repository;

import com.otg.morning.entity.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by OTG on 2018/11/31.
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo,String> {

    SellerInfo findByOpenid(String openid);
}
