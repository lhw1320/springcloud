package com.qdfae.jdk.exception;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;

import org.junit.Test;

/**
 * AutoCloseableTest
 *
 * @author hongwei.lian
 * @date 2018年9月11日 下午2:35:23
 */
public class AutoCloseableTest {
	
	/**
	 * JDK1.7之前
	 *
	 * @author hongwei.lian
	 * @date 2018年9月11日 下午2:56:04
	 */
	@Test
    public void traditionTest() {
        SubAutoCloseable subAutoCloseable = null;
        try {
            subAutoCloseable = new SubAutoCloseable();
            subAutoCloseable.readResouse();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(subAutoCloseable)){
                try {
                    subAutoCloseable.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
	
	/**
	 * JDK7及之后
	 *
	 * @author hongwei.lian
	 * @date 2018年9月11日 下午2:55:55
	 */
	@Test
    public void newTest() {
        try (SubAutoCloseable subAutoCloseable = new SubAutoCloseable()) {
            subAutoCloseable.readResouse();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
	

	public static void main(String[] args) {
//	    try (SmallSubAutoCloseable smallSubAutoCloseable = new SmallSubAutoCloseable(new SubAutoCloseable())) {
//	    	smallSubAutoCloseable.readResouse();
//        } catch (Exception e){
//            e.printStackTrace();
//        }
		
		//test(new SubAutoCloseable());
		
		
		try (OutputStream ostream = new FileOutputStream("11"); OutputStream ostream2 = new FileOutputStream("11")) {
			test(new SubAutoCloseable());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void test(AutoCloseable autoCloseable) {
		 try (SmallSubAutoCloseable smallSubAutoCloseable = new SmallSubAutoCloseable(autoCloseable)) {
		    	smallSubAutoCloseable.readResouse();
	        } catch (Exception e){
	            e.printStackTrace();
	        }
	}
	
}
