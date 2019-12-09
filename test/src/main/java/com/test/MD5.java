package com.test;

import org.apache.hadoop.hive.ql.exec.UDF;
import java.security.MessageDigest;

public class MD5 extends UDF {

	public static String evaluate(String value) {
		StringBuilder sb = new StringBuilder();
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			byte[] bytes = messageDigest.digest(value.getBytes());
			for (int i = 0; i < bytes.length; i++) {
				int tempInt = bytes[i] & 0xff;
				if (tempInt < 16) {
					sb.append(0);
				}
				sb.append(Integer.toHexString(tempInt));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String hello = "123456789";
		System.out.println("MD5加密后的结果：" + evaluate(hello));
	}

}