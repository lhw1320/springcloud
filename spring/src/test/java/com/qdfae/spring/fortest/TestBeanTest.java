package com.qdfae.spring.fortest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试
 * 
 * @author hongwei.lian 
 * @date 2017年12月3日 下午7:35:05
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
@ActiveProfiles("prod")
public class TestBeanTest {

	@Autowired
	private TestBean testBean;
	
	/**
	 * 生产环境
	 *  
	 * @author hongwei.lian  
	 * @date 2017年12月3日 下午7:37:36
	 */
	@Test
	public void testProdBeanShouldInject() {
		String expected = "from production profile";
		String actual = testBean.getContext();
		Assert.assertEquals(expected, actual);
	}
	
}
