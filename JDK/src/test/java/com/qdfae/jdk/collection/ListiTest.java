package com.qdfae.jdk.collection;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.bouncycastle.pqc.math.linearalgebra.BigEndianConversions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.qdfae.jdk.domain.ListingTradeInvestVo;
import com.qdfae.jdk.domain.ProductProfitPo;

public class ListiTest {
	
	private List<ListingTradeInvestVo> tradeInvestVoList = new ArrayList<>();
	
	private List<ProductProfitPo> productProfitPoList = new ArrayList<>();
	
	private BigDecimal maxInvestProfit;
	
	@Before
	public void initList() {
		tradeInvestVoList = new ArrayList<>();
		tradeInvestVoList.add(new ListingTradeInvestVo(1, 8, new BigDecimal("100"), new BigDecimal("500"), new BigDecimal("0.05")));
		//tradeInvestVoList.add(new ListingTradeInvestVo(3, 8, new BigDecimal("5000"), new BigDecimal("50000"), new BigDecimal("0.25")));
		//tradeInvestVoList.add(new ListingTradeInvestVo(2, 8, new BigDecimal("500"), new BigDecimal("5000"), new BigDecimal("0.15")));
	}
	
	@Test
	public void testListSort() {
		productProfitPoList = tradeInvestVoList.stream()
				                                                        .sorted(Comparator.comparing(ListingTradeInvestVo::getInvestAmountMin))
				                                                        .map(tradeInvestVo -> new ProductProfitPo().setAdvisorId(1)
				                                                        		.setDomainId(1).setInvestAmountMax(tradeInvestVo.getInvestAmountMax())
				                                                        		.setInvestAmountMin(tradeInvestVo.getInvestAmountMin())
				                                                        		.setInvestProfit(tradeInvestVo.getInvestProfit()).setProductId(1))
				                                                        .collect(Collectors.toList());
	}
	
	@Test
	public void testListMax() {
		maxInvestProfit = tradeInvestVoList.stream()
																  .map(ListingTradeInvestVo::getInvestProfit)
																  .max(BigDecimal::compareTo)
																  .orElse(null);
	}
	
	@After
	public void println() {
		tradeInvestVoList.forEach(System.out::println);
		productProfitPoList.forEach(System.out::println);
		System.out.println("maxInvestProfit=" + maxInvestProfit);
	}

}
