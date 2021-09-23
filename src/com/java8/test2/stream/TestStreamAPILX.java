package com.java8.test2.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.Test;

import com.java8.test.lambda.Employee;
 

public class TestStreamAPILX {

	/*
	 * 1  给定{1,2,3,4,5} 返回{1,2,9,16,25}
	 * */
	@Test
	public void test1(){
		int[] arr =new int[]{1,2,3,4,5};
		IntStream is = Arrays.stream(arr);
		is.map((e) -> e * e)
			.forEach(System.out::println);
	}
	/*
	 *  2 怎样用map和reduce方法数一数流中有多少个Employee
	 * */
	List<Employee> employee = Arrays.asList(
			new Employee("郑三",118,99.99),
			new Employee("小米",312,34.5),
			new Employee("小米",312,34.5),
			new Employee("小星",32,342),			
			new Employee("西西",39,34.5));
	@Test
	public void test2(){
		Optional<Integer> count = employee.stream()
				.map((e) -> 1)
				.reduce(Integer::sum);
		System.out.println(count);
	}
}
