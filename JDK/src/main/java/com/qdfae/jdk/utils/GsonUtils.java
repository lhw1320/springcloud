package com.qdfae.jdk.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

/**
 * Gson工具类
 *
 * @author hongwei.lian
 * @date 2018年11月13日 上午9:39:36
 */
public final class GsonUtils {

	private static Gson gson = null;

	/**
	 * 1、enableComplexMapKeySerialization()：支持Map的key为复杂对象的形式
	 * 2、serializeNulls()：把null值也转换，默认是不转换null值的，可以选择也转换，为空时输出为{a:null}，而不是{}
	 * 3、setDateFormat()：时间转化为特定格式yyyy-MM-dd HH:mm:ss
	 */
	static {
		if (Objects.isNull(gson)) {
			gson = new GsonBuilder().enableComplexMapKeySerialization()
					                                   .serializeNulls()
					                                   .setDateFormat("yyyy-MM-dd HH:mm:ss")
					                                   .create();
		}
	}

	private GsonUtils() {};

	/**
	 * 将Object对象转换成json字符串
	 *
	 * @param value
	 * @return
	 * @author hongwei.lian
	 * @date 2018年11月13日 上午9:51:50
	 */
	public static String toJson(Object value) {
		return gson.toJson(value);
	}

	/**
	 * 将json字符串转换成JavaBean
	 *
	 * @param jsonString
	 * @param clazz
	 * @return
	 * @author hongwei.lian
	 * @date 2018年11月13日 上午10:21:52
	 */
	public static <T> T jsonToBean(String jsonString, Class<T> clazz) {
		return gson.fromJson(jsonString, clazz);
	}

	/**
	 * 将json字符串转换成List
	 *
	 * @param jsonString
	 * @param clazz
	 * @return
	 * @author hongwei.lian
	 * @date 2018年11月13日 上午10:23:31
	 */
	public static <T> List<T> jsonToList(String jsonString, Class<T> clazz) {
		return gson.fromJson(jsonString, new TypeToken<List<T>>() {}.getType());
	}
	
	/**
	 * 将json字符串转换成Map
	 *
	 * @param jsonString
	 * @param clazz
	 * @return 
	 * @author hongwei.lian
	 * @date 2018年11月14日 下午7:36:41
	 */
	public static <T> Map<String, T> jsonToMap(String jsonString, Class<T> clazz) {
        return gson.fromJson(jsonString, new TypeToken<Map<String, T>>() {}.getType());
    }
	
	/**
	 * 将json字符串转换成List<Map>
	 *
	 * @param jsonString
	 * @param clazz
	 * @return 
	 * @author hongwei.lian
	 * @date 2018年11月14日 下午7:36:57
	 */
	public static <T> List<Map<String, T>> jsonToListMap(String jsonString, Class<T> clazz) {
        return gson.fromJson(jsonString, new TypeToken<List<Map<String, T>>>() {}.getType());
    }
	
	/**
	 * 将json字符串转换成List
	 * 解决泛型问题：泛型在编译期类型被擦除导致报错
	 *
	 * @param json
	 * @param cls
	 * @return 
	 * @author hongwei.lian
	 * @date 2018年11月14日 下午7:39:11
	 */
    public static <T> List<T> jsonToList2(String json, Class<T> cls) {
        List<T> list = new ArrayList<>();
        JsonArray array = new JsonParser().parse(json).getAsJsonArray();
        array.forEach(element ->  list.add(gson.fromJson(element, cls)));
        return list;
    }

}
