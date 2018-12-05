package com.otg.morning.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by OTG on 2018/11/26.
 */
public class JsonUtil {

    public static String toJson(Object object){
        GsonBuilder gsonBuilder=new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson=gsonBuilder.create();
        return gson.toJson(object);
    }
}
