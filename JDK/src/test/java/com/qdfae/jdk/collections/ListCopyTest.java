package com.qdfae.jdk.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.qdfae.jdk.domain.AddressDto;
import com.qdfae.jdk.domain.UserDto;
import com.qdfae.jdk.utils.GsonUtils;

/**
 * list深度复制
 *
 * @author hongwei.lian
 * @date 2021年3月16日 上午11:45:28
 */
public class ListCopyTest {
	
	private List<UserDto> srcList;
	
	private List<UserDto> destList;
	
	@Before
	public void init() {
		srcList = new ArrayList<>();
		UserDto userDto = new UserDto();
		userDto.setName("james");
		userDto.setAge(28);
		AddressDto addressDto = new AddressDto();
		addressDto.setProId(1);
		addressDto.setCityId(1);
		addressDto.setDisId(1);
		List<AddressDto> addressDtoList = new ArrayList<>();
		addressDtoList.add(addressDto);
		userDto.setAddressDtos(addressDtoList);
		srcList.add(userDto);
	}
	
	@Test
	public void testCopyList1() {
		destList = new ArrayList<>();
		destList.add(null);
		Collections.copy(destList, srcList);
		destList.forEach(user -> {
			user.setName(null);
		});
		System.out.println(JSON.toJSON(srcList));
		System.out.println(JSON.toJSON(destList));
	}
	
	@Test
	public void testCopyList2() {
		destList = srcList.stream()
				                     .map(user -> user.setAddressDtos(null))
				                     .collect(Collectors.toList());
		System.out.println(JSON.toJSON(destList));
		System.out.println(JSON.toJSON(srcList));
	}
	
	/**
	 * 深度复制
	 *
	 * @author hongwei.lian
	 * @date 2021年3月16日 上午11:13:28
	 */
	@Test
	public void testCopyList3() {
		destList = GsonUtils.jsonToList2(GsonUtils.toJson(srcList), UserDto.class);
		destList.forEach(user -> {
			user.setName(null);
		});
		System.out.println(JSON.toJSON(destList));
		System.out.println(JSON.toJSON(srcList));
	}

}
