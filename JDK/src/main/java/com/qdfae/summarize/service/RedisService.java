package com.qdfae.summarize.service;

import java.util.Collection;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.qdfae.jdk.exception.EmptyParameterException;
import com.qdfae.jdk.utils.GsonUtils;

/**
 * 操作redis
 *
 * @author hongwei.lian
 * @date 2018年11月12日 下午7:08:35
 */
@Service
public class RedisService {
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	/**
	 * 判断String类型key是否存在
	 *
	 * @param key
	 * @return 
	 * @author hongwei.lian
	 * @date 2018年11月13日 下午1:40:37
	 */
	public boolean hasStringKey(String key) {
		if (StringUtils.isBlank(key)) {
			throw new EmptyParameterException();
		}
		return stringRedisTemplate.opsForValue().getOperations().hasKey(key);
		//return stringRedisTemplate.hasKey(key)
	}
	
	/**
	 * 判断String类型key是否存在
	 *
	 * @param key
	 * @return 
	 * @author hongwei.lian
	 * @date 2018年11月13日 下午1:43:51
	 */
	public boolean nonStringKey(String key) {
		return !hasStringKey(key);
	}

	/**
	 * 设置String类型key，String类型value
	 *
	 * @param key
	 * @param value
	 * @author hongwei.lian
	 * @date 2018年11月12日 下午7:09:02
	 */
	public void setStringKey(String key, String value) {
		if (StringUtils.isBlank(key)) {
			throw new EmptyParameterException();
		}
		stringRedisTemplate.opsForValue().set(key, value);
	}

	/**
	 * 获取String类型value
	 *
	 * @param key
	 * @return
	 * @author hongwei.lian
	 * @date 2018年11月12日 下午7:09:31
	 */
	public String getStringValue(String key) {
		if (StringUtils.isBlank(key)) {
			throw new EmptyParameterException();
		}
		return stringRedisTemplate.opsForValue().get(key);
	}

	/**
	 * 设置String类型key，Object类型value
	 *
	 * @param key
	 * @param value
	 * @author hongwei.lian
	 * @date 2018年11月13日 上午10:30:05
	 */
	public void setStringKey(String key, Object value) {
		if (StringUtils.isBlank(key)) {
			throw new EmptyParameterException();
		}
		stringRedisTemplate.opsForValue().set(key, GsonUtils.toJson(value));
	}
	
	/**
	 * 获取Object类型value
	 *
	 * @param key
	 * @param clazz
	 * @return 
	 * @author hongwei.lian
	 * @date 2018年11月13日 上午10:35:24
	 */
	public <T> T getObjectValue(String key, Class<T> clazz) {
		if (StringUtils.isBlank(key)) {
			throw new EmptyParameterException();
		}
		String json = stringRedisTemplate.opsForValue().get(key);
		return GsonUtils.jsonToBean(json, clazz);
	}
	
	/**
	 * 获取List<T>类型value
	 *
	 * @param key
	 * @param clazz
	 * @return 
	 * @author hongwei.lian
	 * @date 2018年11月13日 上午10:36:54
	 */
	public <T> List<T> getListValue(String key, Class<T> clazz) {
		if (StringUtils.isBlank(key)) {
			throw new EmptyParameterException();
		}
		String json = stringRedisTemplate.opsForValue().get(key);
		return GsonUtils.jsonToList(json, clazz);
	}
	
	/**
	 * 移除单个String类型key
	 *
	 * @param key 
	 * @author hongwei.lian
	 * @date 2018年11月13日 上午10:42:01
	 */
	public void removeSingleStringKey(String key) {
		if (StringUtils.isBlank(key)) {
			throw new EmptyParameterException();
		}
		stringRedisTemplate.opsForValue().getOperations().delete(key);
		//stringRedisTemplate.delete(key);
	}
	
	/**
	 * 移除Collection<String>类型keys
	 *
	 * @param keys 
	 * @author hongwei.lian
	 * @date 2018年11月13日 下午3:15:16
	 */
	public void removeMultiStringKey(Collection<String> keys) {
		if (CollectionUtils.isNotEmpty(keys)) {
			stringRedisTemplate.opsForValue().getOperations().delete(keys);
			//stringRedisTemplate.delete(keys);
		}
	}

}
