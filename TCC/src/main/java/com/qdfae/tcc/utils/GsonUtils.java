package com.qdfae.tcc.utils;

import com.google.gson.Gson;

/**
 * GsonUtils
 * 
 * @author hongwei.lian 
 * @date 2018年1月14日 下午3:38:24
 */
public class GsonUtils {
	
	private static final GsonUtils GSON_UTILS = new GsonUtils();

    private static final Gson GSON = new Gson();

    public static GsonUtils getInstance() {
        return GSON_UTILS;
    }

    public String toJson(Object object) {
        return GSON.toJson(object);
    }

    public <T> T fromJson(String json, Class<T> tClass) {
        return GSON.fromJson(json, tClass);
    }

}
