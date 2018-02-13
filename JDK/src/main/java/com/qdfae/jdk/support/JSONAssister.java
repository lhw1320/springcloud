package com.qdfae.jdk.support;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;

/**
 * JSON辅助
 * 
 * @author hongwei.lian
 * 2018年2月13日 下午7:05:55
 */
public class JSONAssister {
	
	private static SerializeConfig config = null;
	
	static {
		config = new SerializeConfig();
		SimpleDateFormatSerializer dataFormatSerializer = new SimpleDateFormatSerializer("yyyy-MM-dd HH:mm:ss");
		config.put(java.util.Date.class, dataFormatSerializer); 
		config.put(java.sql.Date.class, dataFormatSerializer); 
	}

	private static final SerializerFeature[] features = {
//			SerializerFeature.WriteMapNullValue, // 输出空置字段
//			SerializerFeature.WriteNullListAsEmpty, // list字段如果为null，输出为[]，而不是null
//			SerializerFeature.WriteNullNumberAsZero, // 数值字段如果为null，输出为0，而不是null
//			SerializerFeature.WriteNullBooleanAsFalse, // Boolean字段如果为null，输出为false，而不是null
			//SerializerFeature.WriteNullStringAsEmpty // 字符类型字段如果为null，输出为""，而不是null
	};

	public static Response.ResponseBuilder buildResponse(Object object) {
		return Response.ok(JSONObject.toJSONString(object,config,features)).header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON + ";charset=UTF-8");
	}

}
