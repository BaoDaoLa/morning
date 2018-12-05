package com.otg.morning.dto;

import lombok.Data;

/**
 * Created by OTG on 2018/11/05.
 */
@Data
public class CartDTO {

    /**商品*/
    private String productId;

    /** 数量*/
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
