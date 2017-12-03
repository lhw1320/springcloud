package com.qdfae.spring.el;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

/**
 * 配置类
 * 
 * @author hongwei.lian 
 * @date 2017年12月3日 上午12:07:14
 */
@Configuration
@ComponentScan("com.qdfae.spring.el")
@PropertySource("classpath:com/qdfae/spring/el/test.properties")
public class ElConfig {

	/**
	 * 注入普通字符串
	 */
	@Value("I Love You!")
	private String normal;
	
	/**
	 * 注入操作系统属性
	 */
	@Value("#{ systemProperties['os.name'] }")
	private String osName;
	
	/**
	 * 注入表达式结果
	 */
	@Value("#{ T(java.lang.Math).random() * 100.0 }")
	private double randomNumber;
	
	/**
	 * 注入其他Bean属性
	 */
	@Value("demoService.another")
	private String fromAnother;
	
	/**
	 * 注入文件资源
	 */
	@Value("classpath:com/qdfae/spring/el/test.txt")
	private Resource testFile;
	
	/**
	 * 注入网址资源
	 */
	@Value("http://www.baidu.com")
	private Resource testUrl;
	
	/**
	 * 注入配置文件
	 */
	@Value("${book.name}")
	private String bookName;
	
	@Autowired
	private Environment environment;
	
	/**
	 * 注入配置文件需要使用@PropertySource指定配置文件地址
	 * 若使用@Value注入，则要配置一个PropertySourcesPlaceholderConfigurer的Bean
	 * 注意：Value("${book.name}")使用的是"$"，而不是"#"
	 * 
	 * @return 
	 * @author hongwei.lian  
	 * @date 2017年12月3日 上午12:32:16
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	/**
	 * outputResouce()方法
	 *  
	 * @author hongwei.lian  
	 * @date 2017年12月3日 上午12:35:19
	 */
	public void outputResouce() {
		try {
			System.out.println(normal);
			System.out.println(osName);
			System.out.println(randomNumber);
			System.out.println(fromAnother);
			System.out.println(IOUtils.toString(testFile.getInputStream()));
			System.out.println(IOUtils.toString(testUrl.getInputStream()));
			System.out.println(bookName);
			//注入Properties还可从Environment中获取
			System.out.println(environment.getProperty("book.author"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	
}
