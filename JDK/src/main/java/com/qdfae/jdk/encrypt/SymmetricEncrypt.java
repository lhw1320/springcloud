package com.qdfae.jdk.encrypt;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import org.apache.commons.codec.binary.Base64;

import com.qdfae.jdk.support.ConfigProperties;
import com.springcryptoutils.core.cipher.Mode;
import com.springcryptoutils.core.cipher.symmetric.Base64EncodedCipherer;
import com.springcryptoutils.core.cipher.symmetric.Base64EncodedCiphererImpl;
import com.springcryptoutils.core.cipher.symmetric.Base64EncodedKeyGeneratorImpl;

/**
 * 对称加密解密
 *
 * @author hongwei.lian
 * @date 2018年6月19日 下午7:21:16
 */
public class SymmetricEncrypt {
	
	private static final String INIT_KEY = "key.init";//必须为8位
	
	private static final String KEY = ConfigProperties.getProperty("encryptkey");//建议写在配置文件中

	public static Base64EncodedCipherer getInstance(Mode mode){
		Base64EncodedCiphererImpl cipherer = new Base64EncodedCiphererImpl();
		cipherer.setMode(mode);
		return cipherer;
	}
	
	public static String getInitVector(){
		byte[] keyBytes = Base64.encodeBase64(INIT_KEY.getBytes());
		return new String(keyBytes);
	}
	
	public static String getKey(){
		Base64EncodedKeyGeneratorImpl keygenerator = new Base64EncodedKeyGeneratorImpl();
		try {
			keygenerator.afterPropertiesSet();
			String key = keygenerator.generate();
			return key;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String encryptStr(String message){
		String initializationVector = getInitVector();
		if(KEY == null)
			return null;
		Base64EncodedCipherer cipherer = getInstance(Mode.ENCRYPT); 
		String encryptStr = cipherer.encrypt(KEY, initializationVector, message);
		return encryptStr;
	}
	
	public static String decryptStr(String message){
		String initializationVector = getInitVector();
		if(KEY == null)
			return null;
		Base64EncodedCipherer cipherer = getInstance(Mode.DECRYPT); 
		String decryptStr = cipherer.encrypt(KEY, initializationVector, message);
		return decryptStr;
	}
	
	public static void main(String[] args) {
		String str = "ddsfasasdf";
		String enstr = encryptStr(str);
		System.out.println(enstr);
		System.out.println(decryptStr(enstr));
	}

}
