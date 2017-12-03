package com.qdfae.spring.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Prototype的Bean
 * 
 * @author hongwei.lian 
 * @date 2017年12月2日 下午11:46:29
 */
@Service
@Scope("prototype")
public class DemoPrototypeService {

}
