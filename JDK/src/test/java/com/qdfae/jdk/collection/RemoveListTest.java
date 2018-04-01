package com.qdfae.jdk.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import com.qdfae.jdk.domain.SystypeBaseVo;

/**
 * 遍历移除List中符合条件的元素
 * 可能产生问题：
 * 1、删除元素后List的元素数量会发生变化，随之索引也会发生变化
 * 2、对List进行删除操作可能会产生并发问题，遍历List的时候不允许并发操作
 * 
 * 本次需求：
 * 从已有的List列表中移除typeId是3和4的对象
 *
 * @author hongwei.lian
 * @date 2018年3月28日 下午3:37:30
 */
public class RemoveListTest {
	
	/**
	 * 存储对象的列表
	 */
	private List<SystypeBaseVo> list;
	
	/**
	 * 存储去除元素列表
	 */
	private List<SystypeBaseVo> removeList;
	
	/**
	 * 存储去除后的元素列表
	 */
	private List<SystypeBaseVo> removedList;
	
	/**
	 * 初始化列表
	 *
	 * @author hongwei.lian
	 * @date 2018年3月28日 下午3:40:01
	 */
	@Before
	public void initList() {
		list = new ArrayList<>();
		list.add(new SystypeBaseVo(1, 8, 1, "次"));
		list.add(new SystypeBaseVo(2, 8, 2, "年化"));
		list.add(new SystypeBaseVo(3, 8, 3, "每期"));
		list.add(new SystypeBaseVo(4, 8, 4, "其它"));
	}
	
	/**
	 * 使用普通for循环遍历，没有抛出异常，但结果与预期不符合
	 * 使用ArrayList实现List接口的public E remove(int index)方法
	 *  
	 * @author hongwei.lian  
	 * @date 2018年4月1日 下午6:15:48
	 */
	@Test
	public void testListRemove1() {
		for (int i = 0; i < list.size(); i++) {
			//-- 等价于list.get(i).getTypeId() == 3 || list.get(i).getTypeId() == 4
			if (list.get(i).getTypeId() >= 3) {
				list.remove(i);
			}
		}
		list.forEach(System.out::println);
	}

	/**
	 * 使用普通for循环遍历，没有抛出异常，但结果与预期不符合
	 * 使用ArrayList实现List接口的public boolean remove(Object o)方法
	 *  
	 * @author hongwei.lian  
	 * @date 2018年4月1日 下午7:15:03
	 */
	@Test
	public void testListRemove12() {
		for (int i = 0; i < list.size(); i++) {
			SystypeBaseVo vo = list.get(i);
			//-- 等价于vo.getTypeId() == 3 || vo.getTypeId() == 4
			if (vo.getTypeId() >= 3) {
				list.remove(vo);
			}
		}
		list.forEach(System.out::println);
	}
	
	/**
	 * 使用增强for循环遍历，与上述结果一致，依然与预期结果不符合
	 *  
	 * @author hongwei.lian  
	 * @date 2018年4月1日 下午7:56:54
	 */
	@Test
	public void testListRemove2() {
		for (SystypeBaseVo vo : list) {
			if(vo.getTypeId() >= 3) {
				list.remove(vo);
			}
		}
		list.forEach(System.out::println);
	}
	
	/**
	 *  使用JDK8提供的增强for循环遍历，直接抛出ConcurrentModificationException异常
	 *  
	 * @author hongwei.lian
	 * @date 2018年3月28日 下午2:30:42
	 */
	@Test
	public void testListRemove21() {
		list.forEach(vo -> {
			if(vo.getTypeId() >= 3) {
				list.remove(vo);
			}
		});
		list.forEach(System.out::println);
	}
	
	/**
	 * 使用迭代器遍历
	 * ArrayList类中的内部类Itr重写了Iterator接口中的remove()方法
	 * 因此使用迭代器遍历列表中的元素的同时可以移除其中的元素，不会抛出异常
	 *
	 * @author hongwei.lian
	 * @date 2018年3月28日 下午2:30:48
	 */
	@Test
	public void testListRemove3() {
		Iterator<SystypeBaseVo> it = list.iterator();
		while(it.hasNext()) {
			if(it.next().getTypeId() >= 3)
				it.remove();
		}
		list.forEach(System.out::println);
	}
	
	/**
	 * 使用List接口的removeAll()方法
	 *
	 * @author hongwei.lian
	 * @date 2018年3月28日 下午3:22:53
	 */
	@Test
	public void testListRemove4() {
		removeList = new ArrayList<>();
		list.forEach(vo -> {
			if(vo.getTypeId() >= 3) {
				removeList.add(vo);
			}
		});
		list.removeAll(removeList);
		list.forEach(System.out::println);
	}
	
	/**
	 * 使用JDK8提供的Predicate判断接口
	 *  or()方法和negate()方法和test()方法
	 *  
	 * @author hongwei.lian  
	 * @date 2018年4月1日 下午6:31:20
	 */
	@Test
	public void testListRemove5() {
		Predicate<SystypeBaseVo> filter = vo -> vo.getTypeId() == 3;
		removedList = list.stream()
				.filter(filter
						.or(vo -> vo.getTypeId() == 4)
						.negate())
				.collect(Collectors.toList());
		removedList.forEach(System.out::println);
	}
	
	/**
	 * 使用JDK8提供的Predicate判断接口
	 *  and()方法和test()方法
	 *  
	 * @author hongwei.lian  
	 * @date 2018年4月1日 下午8:22:07
	 */
	@Test
	public void testListRemove51() {
		Predicate<SystypeBaseVo> filter = vo -> vo.getTypeId() != 3;
		removedList = list.stream()
				.filter(filter
						.and(vo -> vo.getTypeId() != 4))
				.collect(Collectors.toList());
		removedList.forEach(System.out::println);
	}
	
	/**
	 * 使用JDK8提供的Predicate判断接口
	 * test()方法
	 *  
	 * @author hongwei.lian  
	 * @date 2018年4月1日 下午8:22:40
	 */
	@Test
	public void testListRemove52() {
		removedList = list.stream()
				.filter(vo -> vo.getTypeId() < 3)
				.collect(Collectors.toList());
		removedList.forEach(System.out::println);
	}
	
	/**
	 * 使用JDK8提供的Collection接口中的removeIf()方法
	 * 看源码可知使用的是迭代器遍历移除的方式，只是做了简单封装
	 *
	 * @author hongwei.lian
	 * @date 2018年3月28日 下午3:24:57
	 */
	@Test
	public void testListRemove6() {
		//-- 符合条件的从列表中移除
		list.removeIf(vo -> vo.getTypeId() >= 3);
		list.forEach(System.out::println);
	}
	
}
