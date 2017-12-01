package com.qdfae.jdk.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * Stream
 * @author hongwei.lian
 * 2017年11月16日 上午9:58:10
 */
public class StreamTest {
	
	/**
	 * 将Collection集合（List或者Set）变成一个Stream接口类型
	 * JDK1.8中Collection接口新增默认方法
	 * 
	 * default Stream<E> stream() {
	 *	    return StreamSupport.stream(this.spliterator(), false);
	 * }
	 * 
	 * default Stream<E> parallelStream() {
	 *	    return StreamSupport.stream(this.spliterator(), true);
	 *   }  
	 * @author hongwei.lian
	 * 2017年11月16日 上午10:03:27
	 */
	@Test
	public void testStream1(){
		List<String> stringCollection = new ArrayList<>();
		stringCollection.add("ddd2");
		stringCollection.add("aaa2");
		stringCollection.add("bbb1");
		stringCollection.add("aaa1");
		stringCollection.add("bbb3");
		stringCollection.add("ccc");
		stringCollection.add("bbb2");
		stringCollection.add("ddd1");
		Stream<String> stream1 = stringCollection.stream();//串行stream
		Stream<String> stream2 = stringCollection.parallelStream();//并行stream
		System.out.println(stream1.equals(stream2));
	} 
	
	/**
	 * 调用stream()方法之后集合变为一个中间态，
	 * 依然还可以调用Stream接口其他方法
	 * 比如：Stream接口的filter()方法，返回一个中间态
	 * Stream<T> filter(Predicate<? super T> arg0);
	 * 该方法是过滤出符合条件的元素
	 * 
	 * 比如：Stream接口的forEach()方法，返回一个最终态
	 * void forEach(Consumer<? super T> arg0);
	 * 该方法是遍历Stream中的每一个元素
	 * 
	 * @author hongwei.lian
	 * 2017年11月16日 上午10:08:39
	 */
	@Test
	public void testStream2(){
		List<String> stringCollection = new ArrayList<>();
		stringCollection.add("ddd2");
		stringCollection.add("aaa2");
		stringCollection.add("bbb1");
		stringCollection.add("aaa1");
		stringCollection.add("bbb3");
		stringCollection.add("ccc");
		stringCollection.add("bbb2");
		stringCollection.add("ddd1");
		
		stringCollection.stream()
		                          .filter(string -> string.startsWith("a"))
		                          .forEach(System.out::println);//"aaa2", "aaa1"
		
		stringCollection.stream()
								  .filter(string -> string.startsWith("a"))
								  .forEachOrdered(System.out::println);//"aaa2", "aaa1"
		//两者区别是什么
        
	} 
	
	/**
	 * 比如：Stream接口的map()方法，返回一个中间态
	 * <R> Stream<R> map(Function<? super T, ? extends R> arg0);
	 * 
	 * @author hongwei.lian
	 * 2017年11月16日 上午10:26:52
	 */
	@Test
	public void testStream3(){
		List<String> stringCollection = new ArrayList<>();
		stringCollection.add("ddd2");
		stringCollection.add("aaa2");
		stringCollection.add("bbb1");
		stringCollection.add("aaa1");
		stringCollection.add("bbb3");
		stringCollection.add("ccc");
		stringCollection.add("bbb2");
		stringCollection.add("ddd1");
		
		stringCollection.stream()
		                          .map(String::toUpperCase)
		                          .forEach(System.out::println);//"DDD2",...
	} 
	
	/**
	 * 比如：Stream接口的sorted()方法，返回一个中间态
	 * Stream<T> sorted();
	 * 
	 * Stream<T> sorted(Comparator<? super T> arg0);
	 * 
	 * @author hongwei.lian
	 * 2017年11月16日 上午10:26:52
	 */
	@Test
	public void testStream4(){
		List<String> stringCollection = new ArrayList<>();
		stringCollection.add("ddd2");
		stringCollection.add("aaa2");
		stringCollection.add("bbb1");
		stringCollection.add("aaa1");
		stringCollection.add("bbb3");
		stringCollection.add("ccc");
		stringCollection.add("bbb2");
		stringCollection.add("ddd1");
		
		stringCollection.stream()
		                          .sorted()
		                          .forEach(System.out::println);//"aaa1",...
	} 
	
	
	/**
	 * 比如：Stream接口的anyMatch()和allMatch()和noneMatch()方法，返回一个最终态
	 * boolean anyMatch(Predicate<? super T> arg0);

	 * boolean allMatch(Predicate<? super T> arg0);

	 * boolean noneMatch(Predicate<? super T> arg0);
	 * 
	 * @author hongwei.lian
	 * 2017年11月16日 上午10:26:52
	 */
	@Test
	public void testStream5(){
		List<String> stringCollection = new ArrayList<>();
		stringCollection.add("ddd2");
		stringCollection.add("aaa2");
		stringCollection.add("bbb1");
		stringCollection.add("aaa1");
		stringCollection.add("bbb3");
		stringCollection.add("ccc");
		stringCollection.add("bbb2");
		stringCollection.add("ddd1");
		
		boolean anyStartsWithA = stringCollection.stream()
			        .anyMatch((s) -> s.startsWith("a"));
	    System.out.println(anyStartsWithA);// true
	   
		boolean allStartsWithA = stringCollection.stream()
		            .allMatch((s) -> s.startsWith("a"));
		System.out.println(allStartsWithA);// false
		
		boolean noneStartsWithZ = stringCollection.stream()
		            .noneMatch((s) -> s.startsWith("z"));
		System.out.println(noneStartsWithZ);// true
	} 
	
	/**
	 * 比如：Stream接口的collect()方法，返回一个最终态
	 * <R, A> R collect(Collector<? super T, A, R> arg0);
	 * 
	 * @author hongwei.lian
	 * 2017年11月16日 上午11:31:17
	 */
	@Test
	public void testStream6(){
		List<String> stringCollection = new ArrayList<>();
		stringCollection.add("ddd2");
		stringCollection.add("aaa2");
		stringCollection.add("bbb1");
		stringCollection.add("aaa1");
		stringCollection.add("bbb3");
		stringCollection.add("ccc");
		stringCollection.add("bbb2");
		stringCollection.add("ddd1");
		
		stringCollection.stream().
		                          collect(Collectors.toSet())
		                          .forEach(System.out::println);
		
	} 
	
	/**
	 * 比如：Stream接口的of()方法，返回一个中间态
	 * public static<T> Stream<T> of(T... values)
	 * 
	 * 比如：Stream接口的flatMap()方法，返回一个中间态
	 * <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper);
	 * 
	 * @author hongwei.lian
	 * 2017年12月1日 下午4:19:13
	 */
	@Test
	public void testStream7() {
		List<String> list1 = new ArrayList<>();
		list1.add("ddd2");
		list1.add("aaa2");
		list1.add("bbb1");
		list1.add("aaa1");
		
		List<String> list2 = new ArrayList<>();
		list2.add("bbb3");
		list2.add("ccc");
		list2.add("bbb2");
		list2.add("ddd1");
		
		List<String> biglist = Stream.of(list1,list2)
										                .flatMap(list -> list.stream())
										                .collect(Collectors.toList());
		biglist.forEach(System.out::println);
	}
	
}
