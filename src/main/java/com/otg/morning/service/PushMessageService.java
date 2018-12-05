package com.otg.morning.service;

import com.otg.morning.dto.OrderDTO;

/**
 * 推送消息
 * Created by OTG on 2018/11/2.
 */
public interface PushMessageService {

    /**
     * 订单状态变更消息
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}
