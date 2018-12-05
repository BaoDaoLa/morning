package com.otg.morning.utils;

import com.otg.morning.enums.CodeEnum;

/**
 * Created by OTG on 2018/11/29.
 */
public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass){
        for (T each:enumClass.getEnumConstants()){
            if(code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    }
}
