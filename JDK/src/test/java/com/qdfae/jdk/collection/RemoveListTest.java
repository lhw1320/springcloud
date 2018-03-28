package com.qdfae.jdk.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
 * @author hongwei.lian
 * @date 2018年3月28日 下午3:37:30
 */
public class RemoveListTest {
	
	private List<SystypeBaseVo> list;
	
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
	}
	
	@Test
	public void testListRemove11() {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getTypeId() == 3) {
				list.remove(i);
			}
		}
		list.forEach(System.out::println);
	}
	
	/**
	 * 
	 *  抛出ConcurrentModificationException异常
	 *  
	 *
	 * @author hongwei.lian
	 * @date 2018年3月28日 下午2:30:42
	 */
	@Test
	public void testListRemove12() {
		list.forEach(vo -> {
			if(vo.getTypeId() == 3) {
				list.remove(vo);
			}
		});
		list.forEach(System.out::println);
	}
	
	/**
	 * 
	 * ArrayList类中的内部类Itr重写了Iterator接口中的remove()方法
	 * 因此使用迭代器遍历列表中的元素的同时可以移除其中的元素，不会抛出异常
	 *
	 * @author hongwei.lian
	 * @date 2018年3月28日 下午2:30:48
	 */
	@Test
	public void testListRemove13() {
		Iterator<SystypeBaseVo> it = list.iterator();
		while(it.hasNext()) {
			if(it.next().getTypeId() == 3)
				it.remove();
		}
		list.forEach(System.out::println);
	}
	
	/**
	 * 
	 * 使用JDK8的Stream接口的filter()方法
	 *
	 * @author hongwei.lian
	 * @date 2018年3月28日 下午2:33:55
	 */
	@Test
	public void testListRemove3() {
		List<SystypeBaseVo> removeList = list.stream()
				.filter(vo -> vo.getTypeId() != 3)
				.collect(Collectors.toList());
		removeList.forEach(System.out::println);
	}
	
	/**
	 * 
	 *
	 * @author hongwei.lian
	 * @date 2018年3月28日 下午3:22:53
	 */
	@Test
	public void testListRemove4() {
		//-- 存储需要删除的元素
		List<SystypeBaseVo> removeList = new ArrayList<>();
		list.forEach(vo -> {
			if(vo.getTypeId() == 3) {
				removeList.add(vo);
			}
		});
		//-- 从原先列表中移除
		list.removeAll(removeList);
		list.forEach(System.out::println);
	}
	
	/**
	 * 方案：
	 * 使用JDK8提供的Collection接口中的removeIf()方法
	 * 源码：
	 *  default boolean removeIf(Predicate<? super E> filter) {
	 *      Objects.requireNonNull(filter);
	 *      boolean removed = false;
	 *      final Iterator<E> each = iterator();
	 *      while (each.hasNext()) {
	 *           if (filter.test(each.next())) {
	 *               each.remove();
	 *               removed = true;
	 *          }
	 *       }
	 *       return removed;
	 *  }
	 * 可以看出使用的是迭代器遍历移除的方式，只是做了简单封装
	 *
	 * @author hongwei.lian
	 * @date 2018年3月28日 下午3:24:57
	 */
	@Test
	public void testListRemove5() {
		//-- 符合条件的从列表中移除
		list.removeIf(vo -> vo.getTypeId() == 3);
		list.forEach(System.out::println);
	}
	
}
