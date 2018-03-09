package com.qdfae.jdk.utils;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qdfae.jdk.support.ResponseCodeBase;

public class RequestResponseUtil {
	public static Set<String> paramWhiteList = new HashSet<String>();
	static {
		paramWhiteList.add("userCode");
		paramWhiteList.add("loginName");
	}

	public static String getRequestParameters(Map<String, String[]> map, boolean isDebugEnabled) {
		try{
			if(MapUtils.isEmpty(map))
				return "-";
			StringBuilder sb  = new StringBuilder();
			for(String key : map.keySet()) {
				if(isDebugEnabled 
						|| key.endsWith("id") || key.endsWith("Id")
						|| paramWhiteList.contains(key)){
					String[] values = map.get(key);
					if(values == null || values.length == 0){
						sb.append(key).append("=").append(",");
					}else {
						sb.append(key).append("=").append(values[0]).append(",");
					}
				}
			}
			if(sb.length() > 0)
				sb.deleteCharAt(sb.length() - 1);
			return sb.toString();
		}catch(Exception e){
			return "-";
		}
	}
	
	public static String getRequestParameters(String requestStr, boolean isDebugEnabled) {
		try{
			if(StringUtils.isBlank(requestStr))
				return "-";
			if(isDebugEnabled)
				return requestStr;
			Object obj = JSONObject.parse(requestStr);
			if (obj instanceof JSONObject) {
				JSONObject jsonObj = (JSONObject)obj;
				JSONObject result = new JSONObject();
				for(String key : jsonObj.keySet()) {
					if(key.endsWith("id") || key.endsWith("Id")
							|| paramWhiteList.contains(key)){
						result.put(key, jsonObj.get(key));
					}
				}
				return result.toJSONString();
			}else if(obj instanceof JSONArray) {
				JSONArray array = (JSONArray)obj;
				JSONArray result = new JSONArray();
				for(int i=0; i<array.size(); i++) {
					JSONObject jsonObj = array.getJSONObject(i);
					JSONObject unit = new JSONObject();
					for(String key : jsonObj.keySet()) {
						if(key.endsWith("id") || key.endsWith("Id")
								|| paramWhiteList.contains(key)){
							unit.put(key, jsonObj.get(key));
							result.add(unit);
						}
					}
				}
				return result.toJSONString();
			}
			return requestStr;
		}catch(Exception  e){
			return requestStr;
		}
	}
	
	public static String getCustomResponseData(String responseStr, boolean isDebugEnabled) {
		try{
			if(StringUtils.isBlank(responseStr))
				return "-";
			if(isDebugEnabled)
				return responseStr;
			JSONObject jsonObj = JSONObject.parseObject(responseStr);
			if(jsonObj.getString("retcode").equals(String.valueOf(ResponseCodeBase.OK))){
				if(jsonObj.containsKey("data")) {
					Object dataObject = jsonObj.get("data");
					int size = 1;
					if(dataObject instanceof JSONArray) {
						JSONArray array = (JSONArray) dataObject;
						size = array.size();
					}
					jsonObj.remove("data");
					jsonObj.put("size", size);
				}
			}
			return jsonObj.toJSONString();
		}catch(Exception  e){
			return responseStr;
		}
	}
}
