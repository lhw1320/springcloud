package com.qdfae.jdk.test;

import java.io.File;

import org.junit.Test;

import com.qdfae.jdk.domain.ResponseVo;
import com.qdfae.jdk.exception.BayMaxBaseException;

/**
 * 文件测试类 
 *
 * @author hongwei.lian
 * @date 2018年3月2日 下午3:25:26
 */
public class FileTest {
	
	@Test
	public void test1() {
		String pdfPath = "C:/Users/Administrator/Downloads/6002324.pdf";
		 File pdfFile = new File(pdfPath);
	     if (!pdfFile.exists() || !pdfFile.isFile()) {
	         throw new BayMaxBaseException(ResponseVo.FAIL, null, "目标文件不存在或不是文件:" + pdfPath);
	     }
	}

}
