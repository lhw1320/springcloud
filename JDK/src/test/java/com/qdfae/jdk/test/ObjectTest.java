package com.qdfae.jdk.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.qdfae.jdk.domain.AddressVo;
import com.qdfae.jdk.domain.ResponseVo;
import com.qdfae.jdk.domain.UserDto;
import com.qdfae.jdk.domain.UserVo;

public class ObjectTest {
	
	@Test
	public void test1() {
		UserVo userVo = new UserVo();
		userVo.setName("hongwei.lian");
		AddressVo addressVo = new AddressVo();
		addressVo.setProId(1);
		addressVo.setCityId(1);
		addressVo.setDisId(1);
		List<AddressVo> addressVos = new ArrayList<>();
		addressVos.add(addressVo);
		userVo.setAddressVos(addressVos);
		
		ResponseVo<UserVo> responseVo = new ResponseVo(1, "操作成功", userVo);
		
		String result = JSON.toJSONString(responseVo);
		System.out.println("===result===" + result);
	    UserVo userVo2 = getObject(result, UserVo.class);
		System.out.println("===userDto1===" + userVo2.getName());
		System.out.println("===userDto2===" + userVo2.getAddressVos());
		System.out.println("===userDto3===" + userVo2.getAddressVos().size());
		System.out.println("===userDto4===" + userVo2.getAddressVos().get(0).getCityId());
		
	}
	
	public static <T extends Object> T getObject(String content, Class<T> clazz) {
		try {
			JSONObject obj = JSON.parseObject(content);
			if(obj == null) {
				return null;
			}
			int retcode = obj.getIntValue("retcode");
			if(retcode != 1) {
				System.out.println("===1===");
			}
			obj = obj.getJSONObject("data");
			if(obj == null) {
				return null;
			}
			return JSON.parseObject(obj.toJSONString(), clazz);
		} catch(JSONException exception) {
			System.out.println("===2===");
			return null;
		}
		
	}
	
	@Test
	public void test2() {
		System.out.println("U_FILE_ACCESS".toLowerCase());
	}

}
