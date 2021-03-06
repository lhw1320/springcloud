﻿package com.qdfae.jdk.collections;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.scripting.xmltags.ForEachSqlNode;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.qdfae.jdk.domain.BizplanRepay;

/**
 * 针对多个年化收益率的还款兑付计划及资产解决方案
 * 
 * 1、目前项目产品仅支持一个年化收益率的还款兑付计划生成
 *       也就是将确权金额和年化收益率传入还款计划策略工厂就可以生成对应的还款计划
 * 
 * 2、由于需求变更，一个产品存在多个投资金额以及对应年化收益率
 *      那么计算利息时就需要区分不同的年化收益率对应的确权金额，
 *      为了利用原来的还款计划策略工厂，那么就需要缓存缓存不同年化收益率的还款计划：
 *      key为年化收益率，value为对应生成的还款计划
 *      也就是有几个年化收益率，就对应生成几个还款计划
 *      
 * 3、生成的还款计划除了计息本金和本金以及利息是不相同的，其它的字段值都是相同的
 *       初步设计是取出缓存中的第一个还款计划列表，将该还款计划为基准去组装缓存中的其它还款计划
 *       组装规则是：获取列表中的每一期还款计划的计息本金和本金以及利息
 *                           然后组装其它还款计划对应的还款期数的计息本金和本金以及利息
 *       那么合并后的还款计划就是最终的融资者需要每一期的还款计划
 *   
 *   4、根据还款计划生成兑付总计划
 *   
 *   5、根据每个投资者的确权信息和兑付总计划生成每个投资者的兑付计划
 *        需要注意的是本金分配还是按照原来分配策略进行分配
 *        本金分配策略：每一期兑付总计划的兑付本金*（投资者确权金额/确权总金额）
 *        那么利息分配就不能按照原来的分配策略进行分配、
 *        原来利息分配策略：每一期兑付总计划的兑付利息*（投资者确权金额/确权总金额）
 *        以上利息分配策略的前提是年化收益率只有一个
 *        那么对应多个年化收益率的利息分配策略调整为：
 *        利息分配策略：
 *        分子：投资者确权金额*对应年化收益率
 *        分母：年化收益率1*对应确权金额+年化收益率2*对应确权金额+年化收益率3*对应确权金额+...
 *                  产品存在几个年化收益率，那么就相加几个
 *        每一期兑付总计划的兑付利息*（分子/分母）
 *        
 *   6、生成每个投资者的兑付计划问题
 *        存在每个投资者的利息之后相加之后和兑付总计划兑付利息相差0.01的问题，
 *        初步设计为将每个投资者利息相加之后去更新兑付总计划的利息
 *        根据更新后的兑付总计划利息去修改还款计划利息
 *     
 *   7、以上步骤做完之后
 *        根据还款计划生成融资者资产
 *        根据兑付计划生成投资者资产
 *        
 *   8、使用TCC补偿模式进行权益资产登记
 *         
 *   9、暂时不考虑提前还款（提前部分和提前一次性）问题
 *        暂时不考虑逾期还款罚息问题
 *        
 *   10、合并还款计划总结
 *        
 * @author hongwei.lian
 * @date 2018年5月9日 下午7:57:13
 */
public class MergeList {
	
	/**
	 * 年化收益率为5%还款计划
	 */
	private List<BizplanRepay> bizplanRepayList1;
	
	/**
	 * 年化收益率为10%还款计划
	 */
	private List<BizplanRepay> bizplanRepayList2;
	
	/**
	 * 年化收益率为15%还款计划
	 */
	private List<BizplanRepay> bizplanRepayList3;
	
	/**
	 * 缓存不同年化收益率的还款计划：key为年化收益率，value为对应生成的还款计划
	 */
	private Map<BigDecimal, List<BizplanRepay>> bizplanRepayMap;
	
	/**
	 * 缓存不同年化收益率的还款计划：为对应生成的还款计划
	 */
	private List<List<BizplanRepay>> bizplanRepayLists;
	
	/**
	 * 合并后的还款计划
	 */
	private List<BizplanRepay> bizplanRepayList;
	
	/**
	 * 初始化
	 *
	 * @author hongwei.lian
	 * @date 2018年5月9日 下午8:00:09
	 */
	@Before
	public void Init() {
		bizplanRepayList1 = new ArrayList<>();
		bizplanRepayList1.add(new BizplanRepay(1, new BigDecimal("60.00"), new BigDecimal("60.00"), new BigDecimal("0.62")));
		bizplanRepayList1.add(new BizplanRepay(2, new BigDecimal("70.00"), new BigDecimal("70.00"), new BigDecimal("0.78")));
		bizplanRepayList2 = new ArrayList<>();
		bizplanRepayList2.add(new BizplanRepay(1, new BigDecimal("25.00"), new BigDecimal("25.00"), new BigDecimal("0.05")));
		bizplanRepayList2.add(new BizplanRepay(2, new BigDecimal("20.00"), new BigDecimal("20.00"), new BigDecimal("0.04")));
		bizplanRepayList3 = new ArrayList<>();
		bizplanRepayList3.add(new BizplanRepay(1, new BigDecimal("15.00"), new BigDecimal("15.00"), new BigDecimal("0.17")));
		bizplanRepayList3.add(new BizplanRepay(2, new BigDecimal("10.00"), new BigDecimal("10.00"), new BigDecimal("0.12")));
		//-- 初始化bizplanRepayMap
		bizplanRepayMap = new HashMap<>();
		bizplanRepayMap.put(new BigDecimal("0.05"), bizplanRepayList1);
		bizplanRepayMap.put(new BigDecimal("0.10"), bizplanRepayList2);
		bizplanRepayMap.put(new BigDecimal("0.15"), bizplanRepayList3);
		//-- 初始化bizplanRepayLists
		bizplanRepayLists = new ArrayList<>();
		bizplanRepayLists.add(bizplanRepayList1);
		bizplanRepayLists.add(bizplanRepayList2);
		bizplanRepayLists.add(bizplanRepayList3);
	}

	/**
	 * 用于遍历合并后的还款计划
	 *
	 * @author hongwei.lian
	 * @date 2018年5月19日 下午2:06:09
	 */
	@After
	public void forEach() {
		bizplanRepayList.forEach(bizplanRepay -> {
			System.out.println("还款计划当前期数：" + bizplanRepay.getPeriodNumber());
			System.out.println("计息本金：" + bizplanRepay.getInterestPrincipal());
			System.out.println("本金：" + bizplanRepay.getPrincipal());
			System.out.println("利息：" + bizplanRepay.getInterest());
		});
	}

	/**
	 * 合并方法1
	 * 循环
	 *
	 * @author hongwei.lian
	 * @date 2018年5月9日 下午8:00:13
	 */
	@Test
	public void testMergeList1() {
		//-- 1、获取key的List集合
		List<BigDecimal> keyList = new ArrayList<>(bizplanRepayMap.keySet());
		
		//-- 2、以第一个List为基准组装对象参数
		List<BizplanRepay> mergeBizplanRepayList = bizplanRepayMap.get(keyList.get(0));
		
		//-- 3、组装每期计息本金、本金、利息
		for (int i = 0; i < mergeBizplanRepayList.size(); i++) {
			for (int j = 1; j < keyList.size(); j++) {
				List<BizplanRepay> otherBizplanRepayList = bizplanRepayMap.get(keyList.get( j));
				//-- 3.1、组装计息本金
				mergeBizplanRepayList.get(i).setInterestPrincipal(mergeBizplanRepayList.get(i).getInterestPrincipal()
						.add(otherBizplanRepayList.get(i).getInterestPrincipal()));
				//-- 3.2、组装本金
				mergeBizplanRepayList.get(i).setPrincipal(mergeBizplanRepayList.get(i).getPrincipal()
						.add(otherBizplanRepayList.get(i).getPrincipal()));
				//-- 3.3、组装利息
				mergeBizplanRepayList.get(i).setInterest(mergeBizplanRepayList.get(i).getInterest()
						.add(otherBizplanRepayList.get(i).getInterest()));
			}
		}
		
		//-- 4、赋值
		bizplanRepayList = mergeBizplanRepayList;
	}
	
	/**
	 * 
	 *
	 * @author hongwei.lian
	 * @date 2018年5月17日 下午1:48:51
	 */
	@Test
	public void testMergeList2() {
		//-- 1、以第一个List为基准组装对象参数
		List<BizplanRepay> mergeBizplanRepayList = bizplanRepayLists.get(0);
		
		//-- 2、组装每期计息本金、本金、利息
		for (int i = 0; i < mergeBizplanRepayList.size(); i++) {
			for (int j = 1; j < bizplanRepayLists.size(); j++) {
				List<BizplanRepay> otherBizplanRepayList = bizplanRepayLists.get(j);
				//-- 2.1、组装计息本金
				mergeBizplanRepayList.get(i).setInterestPrincipal(mergeBizplanRepayList.get(i).getInterestPrincipal()
						.add(otherBizplanRepayList.get(i).getInterestPrincipal()));
				//-- 2.2、组装本金
				mergeBizplanRepayList.get(i).setPrincipal(mergeBizplanRepayList.get(i).getPrincipal()
						.add(otherBizplanRepayList.get(i).getPrincipal()));
				//-- 2.3、组装利息
				mergeBizplanRepayList.get(i).setInterest(mergeBizplanRepayList.get(i).getInterest()
						.add(otherBizplanRepayList.get(i).getInterest()));
			}
		}
		
		//-- 3、赋值
		bizplanRepayList = mergeBizplanRepayList;
	}
	
	/**
	 * <U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner);
	 * 参数1：U identity：
	 *             返回实例u，传递你要返回的U类型对象的初始化实例u
	 * 
	 * 参数2：BiFunction<U, ? super T, U> accumulator：
	 *             累加器accumulator，可以使用二元ℷ表达式（即二元lambda表达式），
	 *             声明你在u上累加你的数据来源t的逻辑
	 *             例如(u,t)->u.sum(t),此时lambda表达式的行参列表是返回实例u和遍历的集合元素t，
	 *             函数体是在u上累加t
	 * 
	 * 参数3：BinaryOperator<U> combiner：
	 *             第三个参数组合器combiner，同样是二元ℷ表达式，(u,t)->u
	 *             lambda表达式行参列表同样是(u,t)，函数体返回的类型则要和第一个参数的类型保持一致
	 *
	 * @author hongwei.lian
	 * @date 2018年5月17日 下午2:31:40
	 */
	@Test
	public void testMergeList4() {
        //List<BizplanRepay> bizplanRepayList = bizplanRepayMap.values().stream().findFirst().get();
        
        //List<BizplanRepay> list = bizplanRepayMap.values().stream().findFirst().get();
        
        /**
         * collect三个参数
         * String concat = stringStream.collect(
         *              StringBuilder::new, 
         *              StringBuilder::append,
     *                  StringBuilder::append)
     *                                 .toString();
         */
        //-- 全部打散，放入Stream中
//        Stream<BizplanRepay> stream = bizplanRepayMap.values().stream().flatMap(bizplanRepayList -> bizplanRepayList.stream());
//        
//        //-- 按照期数分组
//        Map<Integer, List<BizplanRepay>> collect = stream.collect(Collectors.groupingBy(BizplanRepay::getPeriodNumber));
//        //Map<Integer, List<BizplanRepay>> collect = stream.collect(Collectors.groupingBy(BizplanRepay::getPeriodNumber, Collectors.toList()));
//        
//        Stream<List<BizplanRepay>> stream2 = collect.values().stream();
//        
//        //Integer sum = integers.reduce(0, (a, b) -> a+b);
//        stream2.reduce(bizplanRepay, (bizplanRepay1, bizplanRepay1) -> {
//        	
//        });
            
            
            
            
//            //-- 按照期数分组
//            Map<Integer, List<BizplanRepay>> collect = stream.collect(Collectors.groupingBy(BizplanRepay::getPeriodNumber));
//            //Map<Integer, List<BizplanRepay>> collect = stream.collect(Collectors.groupingBy(BizplanRepay::getPeriodNumber, Collectors.toList()));
//            
//            Stream<List<BizplanRepay>> stream2 = collect.values().stream();
//            
//            //Integer sum = integers.reduce(0, (a, b) -> a+b);
//            stream2.reduce(bizplanRepay, (bizplanRepay1, bizplanRepay2) -> {
//            	
//            });
        	
        	
        	
       // });;
        
        
//        List<BizplanRepay> bizplanRepayList = new ArrayList<>();
//        stream2.forEach(bizplanRepayListByperiodNumber -> {
//        	bizplanRepayListByperiodNumber.stream().reduce(, (bizplanRepay1, bizplanRepay2) -> {
//        		bizplanRepay1.setInterestPrincipal(bizplanRepay1.getInterestPrincipal().add(bizplanRepay2.getInterestPrincipal()));
//        		bizplanRepay1.setPrincipal(bizplanRepay1.getPrincipal().add(bizplanRepay2.getPrincipal()));
//        		bizplanRepay1.setInterest(bizplanRepay1.getInterest().add(bizplanRepay2.getInterest()));
//        		bizplanRepayList.add(bizplanRepay1);
//        		return bizplanRepay1;
//        	});
//        });
        //bizplanRepayList.forEach(System.out::println);
        
        //-- 合同同一期的计息本金、本金、利息
//        collect.values().stream().collect(Collectors.reducing(
//        		list, 
//        		(bizplanRepayListByperiodNumber , ) -> {
//        			
//        		}, 
//        		() -> {
//        			
//        		}));
        
//		bizplanRepayMap.values().stream().reduce(
//				bizplanRepayList, 
//				(bizplanRepayList , ) -> {
//					
//				}, 
//				( , ) -> {
//					
//				});
		
		
		
		
		
		
		bizplanRepayList = bizplanRepayLists.stream()
										                             .reduce(
															      		     (bizplanRepayList1, bizplanRepayList2) -> {
																				 for (int i = 0; i < bizplanRepayList1.size(); i++) {
																					  //-- 组装计息本金
																					  bizplanRepayList1.get(i).setInterestPrincipal(
																							  bizplanRepayList1.get(i).getInterestPrincipal()
																							  .add(bizplanRepayList2.get(i).getInterestPrincipal()));
																					  //-- 组装本金
																					  bizplanRepayList1.get(i).setPrincipal(
																							  bizplanRepayList1.get(i).getPrincipal()
																							  .add(bizplanRepayList2.get(i).getPrincipal()));
																					  //-- 组装利息
																					  bizplanRepayList1.get(i).setInterest(
																							  bizplanRepayList1.get(i).getInterest()
																							  .add(bizplanRepayList2.get(i).getInterest()));
																				  }
																				  return bizplanRepayList1;})
															         .get();
	}
	
	@Test
	public void testMergeList3() {
		 //List<BizplanRepay> list = bizplanRepayMap.values().stream().findFirst().get();
		 
		 //Collection<List<BizplanRepay>> values = bizplanRepayMap.values();
		
		//Stream<List<BizplanRepay>> stream = values.stream();
		
		
		//stream.
		
//		 Stream<List<BizplanRepay>> stream = bizplanRepayMap.values().stream();
//		 
//		 List<BizplanRepay> list3 = new ArrayList<>(list);
//		 
//		 list3.forEach(plan -> {
//			 plan.setInterestPrincipal(BigDecimal.ZERO);
//			 plan.setPrincipal(BigDecimal.ZERO);
//			 plan.setInterest(BigDecimal.ZERO);
//		 });
		 
		 //Integer sum = integers.reduce(0, (a, b) -> a+b);
		 
		 
		 bizplanRepayList = bizplanRepayMap.values()
										                              .stream()
										                              .reduce(
										                            		  (bizplanRepayList1, bizplanRepayList2) -> {
																				  for (int i = 0; i < bizplanRepayList1.size(); i++) {
																					  //-- 组装计息本金
																					  bizplanRepayList1.get(i).setInterestPrincipal(
																							  bizplanRepayList1.get(i).getInterestPrincipal()
																							  .add(bizplanRepayList2.get(i).getInterestPrincipal()));
																					  //-- 组装本金
																					  bizplanRepayList1.get(i).setPrincipal(
																							  bizplanRepayList1.get(i).getPrincipal()
																							  .add(bizplanRepayList2.get(i).getPrincipal()));
																					  //-- 组装利息
																					  bizplanRepayList1.get(i).setInterest(
																							  bizplanRepayList1.get(i).getInterest()
																							  .add(bizplanRepayList2.get(i).getInterest()));
																				  }
																				  return bizplanRepayList1;})
										                              .get();
	}
	
}
