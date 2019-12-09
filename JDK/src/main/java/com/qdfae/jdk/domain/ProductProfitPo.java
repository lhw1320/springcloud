package com.qdfae.jdk.domain;

import java.math.BigDecimal;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Accessors(chain = true)
public class ProductProfitPo {
	
	Integer id;
	
	Integer advisorId;
	
	Integer domainId;
	
	Integer productId;
	
	BigDecimal investAmountMin;
	
	BigDecimal investAmountMax;
	
	BigDecimal investProfit;

}
