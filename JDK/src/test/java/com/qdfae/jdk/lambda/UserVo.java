package com.qdfae.jdk.lambda;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

/**
 * 用户信息Vo
 *
 * @author hongwei.lian
 * @date 2020年10月28日 下午5:13:33
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Accessors(chain = true)
public class UserVo implements Serializable {
	
	static final long serialVersionUID = 6166863427962161646L;
	
	Integer userType;
	
	String userCode;

}
