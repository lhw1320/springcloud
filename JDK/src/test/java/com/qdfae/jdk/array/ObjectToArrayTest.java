package com.qdfae.jdk.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.qdfae.jdk.enums.FeePayTypeEnum;

import SysBankpaycenterPo.SysBankpaycenter;
import cn.hutool.core.util.ArrayUtil;

/**
 * Java对象转换为数组测试类
 * 
 * @author hongwei.lian 
 * @date 2018年5月26日 下午6:20:34
 */
public class ObjectToArrayTest {
	
	/**
	 * 存储银行支付结算渠道的List集合
	 */
	private List<SysBankpaycenter> clearCenterList;
	
	/**
	 * 存储银行支付结算渠道Id的Integer数组
	 */
	private Integer[] paycenterIdIntegerArray;
	
	/**
	 * 存储银行支付结算渠道Id的int数组
	 */
	private int[] paycenterIdIntArray;
	
	/**
	 * 存储支付类型对应枚举的数值的Integer数组
	 */
	private Integer[] payTypeIntegerArray;
	
	/**
	 * 存储支付类型对应枚举的数值的int数组
	 */
	private int[] payTypeIntArray;
	
	/**
	 * 初始化
	 * 
	 * 使用到的API
	 * List<E>接口
	 * int size();
	 * 
	 * 凡是继承java.lang.Enum类的自定义枚举在javac
	 * 编译时候都会加上一个public static的
	 * values()方法，方便我们使用
	 * 
	 * 数组的length属性字段是在JVM运行自动
	 * 为数组类java.lang.reflect.Array类提供的length
	 * 字段，可以使用native方法getLength()获取到
	 * 
	 *  
	 * @author hongwei.lian  
	 * @date 2018年5月26日 下午6:29:59
	 */
	@Before
	public void init() {
		//-- 初始化列表
		clearCenterList = new ArrayList<>();
		clearCenterList.add(new SysBankpaycenter(1001, "青岛农商行"));
		clearCenterList.add(new SysBankpaycenter(1002, "中金支付"));
		clearCenterList.add(new SysBankpaycenter(1003, "招商银行"));
		clearCenterList.add(new SysBankpaycenter(1004, "光大银行"));
		clearCenterList.add(new SysBankpaycenter(1005, "民生银行"));
		clearCenterList.add(new SysBankpaycenter(1006, "中金结算"));
		clearCenterList.add(new SysBankpaycenter(1007, "平安银行"));
		clearCenterList.add(new SysBankpaycenter(1008, "青岛清算中心"));
		//-- 创建数组
		paycenterIdIntegerArray = new Integer[clearCenterList.size()];
		paycenterIdIntegerArray = ArrayUtil.newArray(clearCenterList.size());
		paycenterIdIntArray = new int[clearCenterList.size()];
		payTypeIntegerArray = new Integer[FeePayTypeEnum.values().length];
		payTypeIntArray = new int[FeePayTypeEnum.values().length];
	}
	
	/**
	 * 遍历方式一
	 * JDK8之前的foreach形式
	 * 
	 * ArrayUtil来自开源出来的hutool工具包
	 * 主页：http://www.hutool.cn/
	 * GItHub地址：https://github.com/looly/hutool/
	 * 
	 * ArrayUtil工具类
	 * public static <T> boolean isNotEmpty(final T... array) {
	 *     return (array != null && array.length != 0);
	 * }
	 * 
	 * public static boolean isNotEmpty(final int... array) {
	 *    return (array != null && array.length != 0);
	 * }
	 *  
	 * @author hongwei.lian  
	 * @date 2018年5月26日 下午6:57:36
	 */
	@After
	public void foreach1() {
		System.out.println("=========JDK8之钱遍历数组==========");
		if (ArrayUtil.isNotEmpty(paycenterIdIntegerArray)) {
			for (Integer clearCenter : paycenterIdIntegerArray) {
				if (Objects.nonNull(clearCenter)) {
					System.out.println(clearCenter);
				}
			}
		}
		if (ArrayUtil.isNotEmpty(paycenterIdIntArray)) {
			for (int clearCenter : paycenterIdIntArray) {
				if (clearCenter != 0) {
					System.out.println(clearCenter);
				}
			}
		}
		if (ArrayUtil.isNotEmpty(payTypeIntegerArray)) {
			for (Integer payType : payTypeIntegerArray) {
				if (Objects.nonNull(payType)) {
					System.out.println(payType);
				}
			}
		}
		if (ArrayUtil.isNotEmpty(payTypeIntArray)) {
			for (int payType : payTypeIntArray) {
				if (payType != 0) {
					System.out.println(payType);
				}
			}
		}
	}
	
	/**
	 * 遍历方式二
	 * JDK8 Stream API
	 * 
	 * 使用的API
	 * JDK2 提供的Arrays工具类
	 * public static <T> Stream<T> stream(T[] array) {
	 *    return stream(array, 0, array.length);
	 * }   
	 * 
	 * public static IntStream stream(int[] array) {
     *    return stream(array, 0, array.length);
     * }
     * 
     * JDK8提供的Stream<T>接口和Consumer<T>接口
     * public interface Stream<T> extends BaseStream<T, Stream<T>> {
     *     void forEach(Consumer<? super T> action);
     * }
     * 
     * JDK8提供的IntStream接口和IntConsumer接口
     * public interface IntStream extends BaseStream<Integer, IntStream>  {
     *     void forEach(IntConsumer action);
     * }
	 *  
	 * @author hongwei.lian  
	 * @date 2018年5月26日 下午6:58:28
	 */
	@After
	public void foreach2() {
		System.out.println("=========JDK8 Stream API遍历数组==========");
		if (ArrayUtil.isNotEmpty(paycenterIdIntegerArray)) {
			Arrays.stream(paycenterIdIntegerArray)
			           .filter(Objects::nonNull)
			           .forEach(System.out::println);
		}
		if (ArrayUtil.isNotEmpty(paycenterIdIntArray)) {
			Arrays.stream(paycenterIdIntArray)
			           .filter(paycenterId -> paycenterId != 0)
			           .forEach(System.out::println);
		}
		if (ArrayUtil.isNotEmpty(payTypeIntegerArray)) {
			Arrays.stream(payTypeIntegerArray)
			           .filter(Objects::nonNull)
			           .forEach(System.out::println);
		}
		if (ArrayUtil.isNotEmpty(payTypeIntArray)) {
			Arrays.stream(payTypeIntArray)
		 	           .filter(paycenterId -> paycenterId != 0)
	                   .forEach(System.out::println);
		}
	}
	
	/**
	 * 方法一：普通方式
	 * 
	 * List集合转换为数组
	 * 需求：将List集合中存储的对象的paycenterId字段
	 *           取出组装称为这个字段对应数据类型的数组
	 * 数据源：
	 *              List<SysBankpaycenter>
	 * 目标源：          
	 *              Integer[] paycenterIdIntegerArray
	 *              int[] paycenterIdIntArray
	 *  
	 * @author hongwei.lian  
	 * @date 2018年5月26日 下午6:30:16
	 */
	@Test
	public void testListToArray1() {
		for (int i = 0; i < clearCenterList.size(); i++) {
			paycenterIdIntegerArray[i] = clearCenterList.get(i).getPaycenterId();
			paycenterIdIntArray[i] = clearCenterList.get(i).getPaycenterId();
		}
	}
	
	/**
	 * 方法二：JDK8 Stream API
	 * 
	 * List集合转换为数组
	 * 需求：将List集合中存储的对象的paycenterId字段
	 *           取出组装称为这个字段对应数据类型的数组
	 * 数据源：
	 *              List<SysBankpaycenter>
	 * 目标源：          
	 *              Integer[] paycenterIdArray
	 *  
	 * 使用的API
	 * JDK2提供的Collection<E>接口
	 * default Stream<E> stream() {
	 *     return StreamSupport.stream(spliterator(), false);
	 * }
	 * 
	 * JDK8提供的Stream<T>接口、Function<T, R>接口和IntFunction<R>接口
	 * <R> Stream<R> map(Function<? super T, ? extends R> mapper);
	 * <A> A[] toArray(IntFunction<A[]> generator);
	 * 
	 * @author hongwei.lian  
	 * @date 2018年5月26日 下午6:30:16
	 */
	@Test
	public void testListToArray2() {
		paycenterIdIntegerArray = clearCenterList.stream()
				                                                             .map(SysBankpaycenter::getPaycenterId)
				                                                             .toArray(Integer[]::new);
	}
	
	/**
	 * 方法三：JDK8 Stream API
	 * 
	 * List集合转换为数组
	 * 需求：将List集合中存储的对象的paycenterId字段
	 *           取出组装称为这个字段对应数据类型的数组
	 * 数据源：
	 *              List<SysBankpaycenter>
	 * 目标源：          
	 *              int[] paycenterIdArray
	 *  
	 *  使用的API
	 * JDK2提供的Collection<E>接口
	 * default Stream<E> stream() {
	 *     return StreamSupport.stream(spliterator(), false);
	 * }
	 * 
	 * JDK8提供的Stream<T>接口
	 * IntStream mapToInt(ToIntFunction<? super T> mapper);
	 * 
	 * ToIntFunction<T>接口
	 * int applyAsInt(T value);
	 * 
	 * IntStream接口
	 * int[] toArray();
	 *  
	 * @author hongwei.lian  
	 * @date 2018年5月26日 下午8:14:11
	 */
	@Test
	public void testListToArray3() {
		paycenterIdIntArray = clearCenterList.stream()
				                                                     .mapToInt(SysBankpaycenter::getPaycenterId)
				                                                     .toArray();
	}
	
	/**
	 * 方法一：JDK8之前普通方法
	 * 
	 * 枚举转换为数组
	 * 需求：将枚举中每个元素对应的数值，
	 *           取出组装称为这个字段对应数据类型的数组
	 * 数据源：
	 *              FeePayTypeEnum
	 * 目标源：          
	 *              Integer[] payTypeIntegerArray
	 *              int[] payTypeIntArray
	 *  
	 * @author hongwei.lian  
	 * @date 2018年5月27日 下午6:13:11
	 */
	@Test
	public void testEnumToArray1() {
		FeePayTypeEnum[] payTypeEnums = FeePayTypeEnum.values();
		for (int i = 0; i < payTypeEnums.length; i++) {
			payTypeIntegerArray[i] = payTypeEnums[i].getValue();
			payTypeIntArray[i] = payTypeEnums[i].getValue();
		}
	}
	
	/**
	 * 方法二：JDK8 Stream API
	 * 
	 * 枚举转换为数组
	 * 需求：将枚举中每个元素对应的数值，
	 *           取出组装称为这个字段对应数据类型的数组
	 * 数据源：
	 *              FeePayTypeEnum
	 * 目标源：          
	 *              Integer[] payTypeIntegerArray
	 *  
	 * @author hongwei.lian  
	 * @date 2018年5月27日 下午6:23:05
	 */
	@Test
	public void testEnumToArray2() {
		payTypeIntegerArray = Arrays.stream(FeePayTypeEnum.values())
				                                          .map(FeePayTypeEnum::getValue)
				                                          .toArray(Integer[]::new);
	}
	
	/**
	 * 方法三：JDK8 Stream API
	 * 
	 * 枚举转换为数组
	 * 需求：将枚举中每个元素对应的数值，
	 *           取出组装称为这个字段对应数据类型的数组
	 * 数据源：
	 *              FeePayTypeEnum
	 * 目标源：          
	 *              int[] payTypeIntArray
	 *  
	 * @author hongwei.lian  
	 * @date 2018年5月27日 下午6:23:09
	 */
	@Test
	public void testEnumToArray3() {
		payTypeIntArray = Arrays.stream(FeePayTypeEnum.values())
				                                   .mapToInt(FeePayTypeEnum::getValue)
				                                   .toArray();
	}

}
