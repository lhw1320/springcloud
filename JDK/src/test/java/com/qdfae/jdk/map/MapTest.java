package com.qdfae.jdk.map;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.collections4.map.HashedMap;
import org.junit.Test;

public class MapTest {
	
	/**
	 * principal.multiply(investProfit).setScale(zeroplace, paramInt);
	 *
	 * @author hongwei.lian
	 * @date 2018年9月12日 上午11:57:27
	 */
	@Test
	public void test1() {
		BigDecimal unpayPrincipal = new BigDecimal("2000");
		BigDecimal cfmRightMoney = new BigDecimal("6000");
		Map<BigDecimal, BigDecimal> investProfitMap = new HashedMap<>();
		investProfitMap.put(new BigDecimal("0.05"), new BigDecimal("1000"));
		investProfitMap.put(new BigDecimal("0.10"), new BigDecimal("3000"));
		investProfitMap.put(new BigDecimal("0.15"), new BigDecimal("2000"));
		if (MapUtils.isNotEmpty(investProfitMap)) {
			for (Entry<BigDecimal, BigDecimal> entry : investProfitMap.entrySet()) {
				//-- 等比例分配未还本金计算；利息
				BigDecimal divide = entry.getValue().divide(cfmRightMoney, 2, BigDecimal.ROUND_HALF_UP);
				System.out.println("除数" + divide);
				BigDecimal subUnpayPrincipal = unpayPrincipal.multiply(
						entry.getValue().divide(cfmRightMoney, 2, BigDecimal.ROUND_HALF_UP));
				System.out.println(subUnpayPrincipal + "：" + entry.getKey());
				System.out.println(subUnpayPrincipal.multiply(entry.getKey()).setScale(2, BigDecimal.ROUND_HALF_UP));
			}
		}
	}
	
}
