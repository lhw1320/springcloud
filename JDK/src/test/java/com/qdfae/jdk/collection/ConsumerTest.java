package com.qdfae.jdk.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.junit.Before;
import org.junit.Test;

import com.qdfae.jdk.domain.SystypeBaseVo;

/**
 * Consumer接口测试
 * 功能：操作
 *
 * @author hongwei.lian
 * @date 2018年3月28日 下午7:21:09
 */
public class ConsumerTest {
	
	private List<SystypeBaseVo> list;
	
    /**
     * 初始化列表
     *
     * @author hongwei.lian
     * @date 2018年3月28日 下午7:37:44
     */
	@Before
	public void initList() {
		list = new ArrayList<>();
		list.add(new SystypeBaseVo(1, 8, 1, "次"));
		list.add(new SystypeBaseVo(2, 8, 2, "年化"));
		list.add(new SystypeBaseVo(3, 8, 3, "每期"));
	}
	
	/**
	 * 
	 *
	 * @author hongwei.lian
	 * @date 2018年3月28日 下午7:38:03
	 */
	@Test
	public void test1() {
		Consumer<SystypeBaseVo> consumer = vo -> vo.setUpdateOperatorId(678);
		list.forEach(consumer);
		list.forEach(System.out::println);
		
		list.forEach(consumer.andThen(vo -> vo.setCreateOperatorId(678)));
		list.forEach(System.out::println);
		
	}

}
