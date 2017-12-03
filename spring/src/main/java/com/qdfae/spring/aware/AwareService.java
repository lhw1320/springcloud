package com.qdfae.spring.aware;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

/**
 * Spring Aware示例Bean
 * 
 * @author hongwei.lian 
 * @date 2017年12月3日 下午4:45:45
 */
@Service
public class AwareService implements BeanNameAware, ResourceLoaderAware {

	private String beanName;
	
	private ResourceLoader loader;
	
	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.loader = resourceLoader;
	}

	@Override
	public void setBeanName(String name) {
		this.beanName = name;
	}
	
	/**
	 * outputResult()方法
	 *  
	 * @author hongwei.lian  
	 * @date 2017年12月3日 下午4:48:17
	 */
	public void outputResult() {
		System.out.println("Bean的名称为：" + beanName);
		Resource resource = loader.getResource("classpath:com/qdfae/spring/aware/test.txt");
		try {
			System.out.println("ResourceLoader加载的文件内容为：" + IOUtils.toString(resource.getInputStream()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
