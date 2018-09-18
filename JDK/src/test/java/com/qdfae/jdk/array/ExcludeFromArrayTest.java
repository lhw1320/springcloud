package com.qdfae.jdk.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.After;
import org.junit.Test;

import com.qdfae.jdk.enums.AuditStatusEnum;

public class ExcludeFromArrayTest {
	
	private AuditStatusEnum[] auditStatuss;
	
	@After
	public void foeach() {
		if (ArrayUtils.isNotEmpty(auditStatuss)) {
			for (AuditStatusEnum status : auditStatuss) {
				System.out.println(status);
			}
		}
	}
	
	@Test
	public void test1() {
		//-- 数组
		//List<AuditStatusEnum> list = Arrays.asList(AuditStatusEnum.values());
		for (AuditStatusEnum status : AuditStatusEnum.values()) {
			if (Objects.equals(status, AuditStatusEnum.审核不通过)) {
			}
		}
	}
	
	@Test
	public void test2() {
		List<AuditStatusEnum> list = new ArrayList<>(Arrays.asList(AuditStatusEnum.values()));
		list.remove(AuditStatusEnum.审核不通过);
		auditStatuss= list.toArray(new AuditStatusEnum[1]);
	}
	
	@Test
	public void test3() {
		auditStatuss = Arrays.stream(AuditStatusEnum.values())
										   .filter(status -> ObjectUtils.notEqual(status, AuditStatusEnum.审核不通过))
									       .toArray(AuditStatusEnum[]::new);
	}

}
