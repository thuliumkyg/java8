package com.java8.test2.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

import com.java8.test.lambda.Employee;
 

/*
 * 一、Stream 的三个操作步骤
 * 	   1. 创建Stream
 * 	   2. 中间操作
 * 	   3. 终止操作（终端操作）	
 * */
public class TestStreamAPI2 {
   //中间操作
	/* 筛选与切片
	 * filter--接收Lambda，从流中排除某些元素
	 * limit -- 截断流，使其元素不超过给定数量。
	 * skip(n)--跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足n个，则返回一个空流。与limit(n)互补
	 * distinct--筛选，通过流所生成元素的hashCode() 和equals()去除重复元素
	 * */
	
	List<Employee> employee = Arrays.asList(
			new Employee("郑三",118,99.99),
			new Employee("小米",312,34.5),
			new Employee("小米",312,34.5),
			new Employee("小米",312,34.5),
			
			new Employee("西西",39,34.5));
	
	
	@Test
	public void test4(){
		Stream<Employee> s=	employee.stream()
				.filter((e) -> e.getAge() >55)
				.distinct();
		 s.forEach(System.out::println);
	}
	
	@Test
	public void test3(){
		employee.stream()
				.filter((e) -> {
				 System.out.println("短路！");	// &&  || 短路，可以提高 效率
				return e.getAge() > 35;
				})
				.skip(1)
				.limit(2).forEach(System.out::println);
	}
	
	
	@Test
	public void test2(){
		employee.stream()
				.filter((e) -> {
				 System.out.println("短路！");	// &&  || 短路，可以提高 效率
				return e.getAge() > 55;
				})
				.limit(2).forEach(System.out::println);
	}
	
	
	//内部迭代：迭代操作有 Stream API 完成     （外部迭代：Iterator）
	@Test
	public void test1(){
		Stream<Employee> s=	employee.stream()
				.filter((e) -> e.getAge() >55);
		 s.forEach(System.out::println);
	}
	
	/*	
	 * 映射
	 * 	map--接收Lambda，将元素 转换成其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
	 *  flatMap--接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流链接成一个流
	 * */
	@Test
	public void test5(){
		List<String> list = Arrays.asList("aa","bb","cc");
		list.stream()
			.map((str) -> str.toUpperCase())
			.forEach(System.out::println);
		System.out.println("----------------");
		
		employee.stream()
				.map(Employee::getName)
				.forEach(System.out::println);
		System.out.println("----------------");
		
		Stream<Stream<Character>> stream = list.stream()
			.map(TestStreamAPI2::filterCharacter); //{{a,a},{b,b}}
		stream.forEach((sm) -> {
			sm.forEach(System.out::println);
		});
		System.out.println("----------------");
		
		Stream<Character> sm = list.stream()
			.flatMap(TestStreamAPI2::filterCharacter); //{a,a,b,b}
		sm.forEach(System.out::println);
	}
	
	public static Stream<Character> filterCharacter(String str){
		List<Character> list = new ArrayList<>();
		for(Character ch : str.toCharArray()){
			list.add(ch);
		}
		return  list.stream();
	}
	
	/*
	 * 排序
	 * 		sorted() -- 自然排序(Comparable)
	 * 		sorted(Comparator com) --定制排序(Comparator)
	 */	
	@Test
	public void test7(){
		List<String> list = Arrays.asList("dd","aa","ee","bb","cc");
		list.stream()
			.sorted()
			.forEach(System.out::println);
		
		 
	}
}
