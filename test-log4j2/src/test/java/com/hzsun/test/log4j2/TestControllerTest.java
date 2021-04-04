package com.hzsun.test.log4j2;

import com.hzsun.demotest.commons.utils.StringUtil;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: louph
 * @Date: 2020/1/7 0007
 */
public class TestControllerTest {
	private String 成员变量;
	private String adada;

	@Test
	public void demoTest(){

		List<String> list = new ArrayList<String>();
		for(int i=0;i<10;i++){
			list.add(StringUtil.fillLeft("1",'0',i+1));
		}
//		list.forEach(p-> System.out.println(p));
//		list.forEach(System.out::println);
//
//		list.stream().filter(t -> t.length()<5).forEach(System.out::println);
//		list.stream().filter(t -> t.endsWith("001")).forEach(System.out::println);
//
//		list.stream().filter(t -> t.length()<5&&t.endsWith("001")).forEach(System.out::println);
//
//
//		Predicate<String> ageFilter = t -> t.length()<5;
//		Predicate<String> sexFilter = t -> t.endsWith("001");

//		list.stream().filter(ageFilter).filter(sexFilter).forEach(System.out::println);
//
//		list.stream().filter(ageFilter.and(sexFilter)).forEach(System.out::println);

//		list.stream().limit(2).filter(t -> t.length()<5).forEach(System.out::println);
//		list.stream().sorted(Comparator.comparing(String::length))
//				.forEach(e -> System.out.println(e.toString()));
//
//		list.stream().sorted((s1,s2) -> s2.length()-s1.length())
//				.forEach(e -> System.out.println(e.toString()));
//		System.out.printf(list.stream().min(Comparator.comparing(String::length)).get());
//		System.out.printf(list.stream().max(Comparator.comparing(String::length)).get());
//		System.out.println(list.stream().reduce((e,f)->e+f).get());
//		list.stream().filter(e->e.length()>8).collect(Collectors.toList()).forEach(System.out::println);
//		try {
//			Thread.sleep(2000l);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		System.err.println("===========================");
//		list.forEach(System.out::println);
//		System.out.println(list.stream().map(e->e).collect(Collectors.joining(",")));

//		list.stream().filter(e->e.length()>2).map(e->e).collect(Collectors.toMap(String::length,e->e)).forEach(((key,val)-> System.out.println(key+":"+val)));

		List<Integer> ages = Arrays.asList(2,5,3,4,7);
		IntSummaryStatistics statistics = ages.stream().mapToInt(e -> e).summaryStatistics();
		System.out.println("最大值: " + statistics.getMax());
		System.out.println("最小值: " + statistics.getMin());
		System.out.println("平均值: " + statistics.getAverage());
		System.out.println("总和: " + statistics.getSum());
		System.out.println("个数: " + statistics.getCount());
	}


}
interface A{
	public abstract void run(String a);
}