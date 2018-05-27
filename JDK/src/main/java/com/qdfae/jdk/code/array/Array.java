package com.qdfae.jdk.code.array;

/**
 * java.lang.reflect.Array源码解读
 * 
 * Array类提供静态方法来动态创建和访问Java数组
 * 
 * 数组允许在获取或设置值的操作期间扩大转换次数，
 * 但如果缩小转换发生则抛出IllegalArgumentException异常
 */
public final class Array {
	
	/**
	 * 构造方法：数组不可实例化
	 */
	private Array() {}
	
	
	/**
	 * 静态方法
	 */
	/**
	 * 用指定的组件类型和长度创建一个新数组
	 * 调用这个方法相当于创建一个数组
	 * 如下：
	 * int[] x = {length};
	 * Array.newInstance(componentType, x);
	 * 
	 * 新数组的维数必须不超过255
	 * 
	 * 如果指定的componentType参数为null，则抛出NullPointerException
	 * 如果componentType是Void＃TYPE或者请求的数组实例的维数超过255，
	 * 则抛出IllegalArgumentException
	 * 
	 * @param componentType 表示新数组的组件类型的Class对象
	 * @param length 表示新数组的长度
	 * @return 新的数组
	 * @throws NegativeArraySizeException 如果指定的长度是负值，
	 * 则抛出NegativeArraySizeException
	 */
	public static Object newInstance(Class<?> componentType, int length)
        throws NegativeArraySizeException {
        return newArray(componentType, length);
	 }
	
	/**
	 * 用指定的组件类型和尺寸创建一个新数组
	 * 
	 * 新数组的维数必须不超过255
	 * 
	 * 如果指定的componentType参数为null，则抛出NullPointerException
	 * 
	 * @param componentType Class对象表示新数组的组件类型
	 * @param dimensions 一个int数组，表示新数组的维数
	 * @return 新的数组
	 * @throws IllegalArgumentException 如果指定的维度参数是零维数组，
	 * 则componentType为Void＃TYPE，或者请求的数组实例的维度数量超过255，
	 * 则抛出IllegalArgumentException
	 * @throws NegativeArraySizeException 如果指定维度参数中的任何组件为负数
	 * 则抛出NegativeArraySizeException
	 */
	public static Object newInstance(Class<?> componentType, int... dimensions)
        throws IllegalArgumentException, NegativeArraySizeException {
        return multiNewArray(componentType, dimensions);
	}
	
	/**
	 * 以int形式返回指定数组对象的长度
	 * 
	 * @param array 数组
	 * @return 数组的长度
	 * @throws IllegalArgumentException 如果对象参数不是数组，
	 * 则抛出IllegalArgumentException
	 */
	public static native int getLength(Object array)
        throws IllegalArgumentException;
	
	/**
	 * 返回指定数组对象中索引组件的值
	 * 如果该对象具有基本类型，则该值将自动包装在对象中
	 * 
	 * 如果指定的对象为null，则抛出NullPointerException
	 * 
	 * @param array 数组
	 * @param index 索引
	 * @return 指定数组中的索引组件的（可能包装的）值
	 * @throws IllegalArgumentException 如果对象参数不是数组，
	 * 则抛出IllegalArgumentException
	 * @throws ArrayIndexOutOfBoundsException 如果指定的索引参数是负数，
	 * 或者大于或等于指定数组的长度，则抛出ArrayIndexOutOfBoundsException
	 */
	public static native Object get(Object array, int index)
        throws IllegalArgumentException, ArrayIndexOutOfBoundsException;
	
	/**
	 * 以布尔值的形式返回指定数组对象中索引组件的值
	 * 
	 * 如果指定的对象为null，则抛出NullPointerException
	 * 
	 * @param array 数组
	 * @param index 索引
	 * @return 指定数组中索引组件的值
	 * @throws IllegalArgumentException 如果指定的对象不是数组，
	 * 或者索引元素无法通过标识或扩展转换转换为返回类型
	 * 则抛出IllegalArgumentException
	 * @throws ArrayIndexOutOfBoundsException 如果指定的索引参数是负数，
	 * 或者大于或等于指定数组的长度，则抛出ArrayIndexOutOfBoundsException
	 */
	public static native boolean getBoolean(Object array, int index)
        throws IllegalArgumentException, ArrayIndexOutOfBoundsException;
	
	/**
	 * 以字节的形式返回指定数组对象中索引组件的值
	 * 
	 * 如果指定的对象为null，则抛出NullPointerException
	 * 
	 * @param array 数组
	 * @param index 索引
	 * @return 指定数组中索引组件的值
	 * @throws IllegalArgumentException 如果指定的对象不是数组，
	 * 或者索引元素无法通过标识或扩展转换转换为返回类型
	 * 则抛出IllegalArgumentException
	 * @throws ArrayIndexOutOfBoundsException 如果指定的索引参数是负数，
	 * 或者大于或等于指定数组的长度，则抛出ArrayIndexOutOfBoundsException
	 */
	public static native byte getByte(Object array, int index)
        throws IllegalArgumentException, ArrayIndexOutOfBoundsException;
	
	/**
	 * 以char的形式返回指定数组对象中索引组件的值
	 * 
	 * 如果指定的对象为null，则抛出NullPointerException
	 * 
	 * @param array 数组
	 * @param index 索引
	 * @return 指定数组中索引组件的值
	 * @throws IllegalArgumentException 如果指定的对象不是数组，
	 * 或者索引元素无法通过标识或扩展转换转换为返回类型
	 * 则抛出IllegalArgumentException
	 * @throws ArrayIndexOutOfBoundsException 如果指定的索引参数是负数，
	 * 或者大于或等于指定数组的长度，则抛出ArrayIndexOutOfBoundsException
	 */
	public static native char getChar(Object array, int index)
        throws IllegalArgumentException, ArrayIndexOutOfBoundsException;
	
	/**
	 * 以short的形式返回指定数组对象中索引组件的值
	 * 
	 * 如果指定的对象为null，则抛出NullPointerException
	 * 
	 * @param array 数组
	 * @param index 索引
	 * @return 指定数组中索引组件的值
	 * @throws IllegalArgumentException 如果指定的对象不是数组，
	 * 或者索引元素无法通过标识或扩展转换转换为返回类型
	 * 则抛出IllegalArgumentException
	 * @throws ArrayIndexOutOfBoundsException 如果指定的索引参数是负数，
	 * 或者大于或等于指定数组的长度，则抛出ArrayIndexOutOfBoundsException
	 */
	public static native short getShort(Object array, int index)
        throws IllegalArgumentException, ArrayIndexOutOfBoundsException;
	
	/**
	 * 以int的形式返回指定数组对象中索引组件的值
	 * 
	 * 如果指定的对象为null，则抛出NullPointerException
	 * 
	 * @param array 数组
	 * @param index 索引
	 * @return 指定数组中索引组件的值
	 * @throws IllegalArgumentException 如果指定的对象不是数组，
	 * 或者索引元素无法通过标识或扩展转换转换为返回类型
	 * 则抛出IllegalArgumentException
	 * @throws ArrayIndexOutOfBoundsException 如果指定的索引参数是负数，
	 * 或者大于或等于指定数组的长度，则抛出ArrayIndexOutOfBoundsException
	 */
	public static native int getInt(Object array, int index)
        throws IllegalArgumentException, ArrayIndexOutOfBoundsException;

	/**
	 * 以long形式返回指定数组对象中索引组件的值
	 * 
	 * 如果指定的对象为null，则抛出NullPointerException
	 * 
	 * @param array 数组
	 * @param index 索引
	 * @return 指定数组中索引组件的值
	 * @throws IllegalArgumentException 如果指定的对象不是数组，
	 * 或者索引元素无法通过标识或扩展转换转换为返回类型
	 * 则抛出IllegalArgumentException
	 * @throws ArrayIndexOutOfBoundsException 如果指定的索引参数是负数，
	 * 或者大于或等于指定数组的长度，则抛出ArrayIndexOutOfBoundsException
	 */
	public static native long getLong(Object array, int index)
        throws IllegalArgumentException, ArrayIndexOutOfBoundsException;
	
	/**
	 * 以float形式返回指定数组对象中索引组件的值
	 * 
	* 如果指定的对象为null，则抛出NullPointerException
	 * 
	 * @param array 数组
	 * @param index 索引
	 * @return 指定数组中索引组件的值
	 * @throws IllegalArgumentException 如果指定的对象不是数组，
	 * 或者索引元素无法通过标识或扩展转换转换为返回类型
	 * 则抛出IllegalArgumentException
	 * @throws ArrayIndexOutOfBoundsException 如果指定的索引参数是负数，
	 * 或者大于或等于指定数组的长度，则抛出ArrayIndexOutOfBoundsException
	 */
	public static native float getFloat(Object array, int index)
        throws IllegalArgumentException, ArrayIndexOutOfBoundsException;
	
	/**
	 * 以double形式返回指定数组对象中索引组件的值
	 * 
	 * 如果指定的对象为null，则抛出NullPointerException
	 * 
	 * @param array 数组
	 * @param index 索引
	 * @return 指定数组中索引组件的值
	 * @throws IllegalArgumentException 如果指定的对象不是数组，
	 * 或者索引元素无法通过标识或扩展转换转换为返回类型
	 * 则抛出IllegalArgumentException
	 * @throws ArrayIndexOutOfBoundsException 如果指定的索引参数是负数，
	 * 或者大于或等于指定数组的长度，则抛出ArrayIndexOutOfBoundsException
	 */
	public static native double getDouble(Object array, int index)
        throws IllegalArgumentException, ArrayIndexOutOfBoundsException;

	/**
	 * 将指定数组对象的索引组件的值设置为指定的新值
	 * 如果数组具有原始组件类型，则新值将自动解包
	 * 
	 * 如果指定的对象参数为null，则抛出NullPointerException
	 * 
	 * @param array 数组
	 * @param index 索引
	 * @param value 索引组件的新值
	 * @throws IllegalArgumentException 如果指定的对象参数不是一个数组，
	 * 或者如果阵列组件类型是原始的，解包转换失败，则抛出IllegalArgumentException
	 * @throws ArrayIndexOutOfBoundsException 如果指定的索引参数是负数，
	 * 或者大于或等于指定数组的长度，则抛出ArrayIndexOutOfBoundsException
	 */
	public static native void set(Object array, int index, Object value)
		throws IllegalArgumentException, ArrayIndexOutOfBoundsException;
	
	/**
	 * 将指定数组对象的索引组件的值设置为指定的布尔值
	 * 
	 * 如果指定的对象参数为null，则抛出NullPointerException
	 * 
	 * @param array 数组
	 * @param index 索引
	 * @param z 索引组件的新值
	 * @throws IllegalArgumentException 如果指定的对象参数不是一个数组，
	 * 或者如果阵列组件类型是原始的，解包转换失败，则抛出IllegalArgumentException
	 * @throws ArrayIndexOutOfBoundsException 如果指定的索引参数是负数，
	 * 或者大于或等于指定数组的长度，则抛出ArrayIndexOutOfBoundsException 
	 */
	public static native void setBoolean(Object array, int index, boolean z)
        throws IllegalArgumentException, ArrayIndexOutOfBoundsException;

	/**
	 * 将指定数组对象的索引组件的值设置为指定的byte值
	 * 
	 * @param array
	 * @param index
	 * @param b
	 * @throws IllegalArgumentException 如果指定的对象参数不是一个数组，
	 * 或者如果阵列组件类型是原始的，解包转换失败，则抛出IllegalArgumentException
	 * @throws ArrayIndexOutOfBoundsException 如果指定的索引参数是负数，
	 * 或者大于或等于指定数组的长度，则抛出ArrayIndexOutOfBoundsException
	 */
	public static native void setByte(Object array, int index, byte b)
	    throws IllegalArgumentException, ArrayIndexOutOfBoundsException;
	
	/**
	 * 将指定数组对象的索引组件的值设置为指定的char值
	 * 
	 * 如果指定的对象参数为null，则抛出NullPointerException
	 * 
	 * @param array 数组
	 * @param index 索引
	 * @param c 索引组件的新值
	 * @throws IllegalArgumentException 如果指定的对象参数不是一个数组，
	 * 或者如果阵列组件类型是原始的，解包转换失败，则抛出IllegalArgumentException
	 * @throws ArrayIndexOutOfBoundsException 如果指定的索引参数是负数，
	 * 或者大于或等于指定数组的长度，则抛出ArrayIndexOutOfBoundsException 
	 */
	public static native void setChar(Object array, int index, char c)
        throws IllegalArgumentException, ArrayIndexOutOfBoundsException;
	
	/**
	 * 将指定数组对象的索引组件的值设置为指定的short值
	 * 
	 * 如果指定的对象参数为null，则抛出NullPointerException
	 * 
	 * @param array 数组
	 * @param index 索引
	 * @param s 索引组件的新值
	 * @throws IllegalArgumentException 如果指定的对象参数不是一个数组，
	 * 或者如果阵列组件类型是原始的，解包转换失败，则抛出IllegalArgumentException
	 * @throws ArrayIndexOutOfBoundsException 如果指定的索引参数是负数，
	 * 或者大于或等于指定数组的长度，则抛出ArrayIndexOutOfBoundsException 
	 */
	public static native void setShort(Object array, int index, short s)
        throws IllegalArgumentException, ArrayIndexOutOfBoundsException;
	
	/**
	 * 将指定数组对象的索引组件的值设置为指定的int值
	 * 
	 * 如果指定的对象参数为null，则抛出NullPointerException
	 * 
	 * @param array 数组
	 * @param index 索引
	 * @param i 索引组件的新值
	 * @throws IllegalArgumentException 如果指定的对象参数不是一个数组，
	 * 或者如果阵列组件类型是原始的，解包转换失败，则抛出IllegalArgumentException
	 * @throws ArrayIndexOutOfBoundsException 如果指定的索引参数是负数，
	 * 或者大于或等于指定数组的长度，则抛出ArrayIndexOutOfBoundsException 
	 */
	public static native void setInt(Object array, int index, int i)
        throws IllegalArgumentException, ArrayIndexOutOfBoundsException;
	
	/**
	 * 将指定数组对象的索引组件的值设置为指定的long值
	 * 
	 * 如果指定的对象参数为null，则抛出NullPointerException
	 * 
	 * @param array 数组
	 * @param index 索引
	 * @param l 索引组件的新值
	 * @throws IllegalArgumentException 如果指定的对象参数不是一个数组，
	 * 或者如果阵列组件类型是原始的，解包转换失败，则抛出IllegalArgumentException
	 * @throws ArrayIndexOutOfBoundsException 如果指定的索引参数是负数，
	 * 或者大于或等于指定数组的长度，则抛出ArrayIndexOutOfBoundsException 
	 */
	public static native void setLong(Object array, int index, long l)
	     throws IllegalArgumentException, ArrayIndexOutOfBoundsException;
 
	/**
	 * 将指定数组对象的索引组件的值设置为指定的float值
	 * 
	 * 如果指定的对象参数为null，则抛出NullPointerException
	 * 
	 * @param array 数组
	 * @param index 索引
	 * @param f 索引组件的新值
	 * @throws IllegalArgumentException 如果指定的对象参数不是一个数组，
	 * 或者如果阵列组件类型是原始的，解包转换失败，则抛出IllegalArgumentException
	 * @throws ArrayIndexOutOfBoundsException 如果指定的索引参数是负数，
	 * 或者大于或等于指定数组的长度，则抛出ArrayIndexOutOfBoundsException 
	 */
	public static native void setFloat(Object array, int index, float f)
	     throws IllegalArgumentException, ArrayIndexOutOfBoundsException;
	
	/**
	 * 将指定数组对象的索引组件的值设置为指定的double值
	 * 
	 * 如果指定的对象参数为null，则抛出NullPointerException
	 * 
	 * @param array 数组
	 * @param index 索引
	 * @param d 索引组件的新值
	 * @throws IllegalArgumentException 如果指定的对象参数不是一个数组，
	 * 或者如果阵列组件类型是原始的，解包转换失败，则抛出IllegalArgumentException
	 * @throws ArrayIndexOutOfBoundsException 如果指定的索引参数是负数，
	 * 或者大于或等于指定数组的长度，则抛出ArrayIndexOutOfBoundsException 
	 */
	public static native void setDouble(Object array, int index, double d)
	    throws IllegalArgumentException, ArrayIndexOutOfBoundsException;

	 /**
	  * 私有方法
	  */
	 /**
	  * 
	  * 
	  * @param componentType
	  * @param length
	  * @return
	  * @throws NegativeArraySizeException 
	  */
	 private static native Object newArray(Class<?> componentType, int length)
	     throws NegativeArraySizeException;

	 /**
	  * 
	  * 
	  * @param componentType
	  * @param dimensions
	  * @return
	  * @throws IllegalArgumentException
	  * @throws NegativeArraySizeException 
	  */
     private static native Object multiNewArray(Class<?> componentType,
         int[] dimensions)
         throws IllegalArgumentException, NegativeArraySizeException;
	 
}
