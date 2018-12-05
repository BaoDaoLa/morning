package com.otg.morning.service;

import com.otg.morning.entity.SellerInfo;

/**
 * 卖家端
 * Created by OTG on 2018/11/1.
 */
public interface SellerService {

    /**
     * 通过openid查询
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);
}
