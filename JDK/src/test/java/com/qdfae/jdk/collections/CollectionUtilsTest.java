package com.qdfae.jdk.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;

public class CollectionUtilsTest {
	
	@Test
	public void testRemove() {
		List<Integer> allList = new ArrayList<>();
		allList.add(1);
		allList.add(2);
		allList.add(3);
		List<Integer> removeList = new ArrayList<>();
		removeList.add(1);
//		allList.remove(removeList);
//		allList.remove(1);
		
		allList.removeAll(removeList);
		allList.forEach(System.out::println);
		
//		Collection removeAll = CollectionUtils.removeAll(allList, removeList);
//		allList.clear();
//		allList.addAll(removeAll);
//		allList.forEach(System.out::println);
		
		Predicate<Integer> predicate = removeList::contains;
		allList = allList.stream().filter(predicate.negate()).collect(Collectors.toList());
//		allList.forEach(System.out::println);
	}

}
