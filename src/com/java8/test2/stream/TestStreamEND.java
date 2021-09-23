package com.java8.test2.stream;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.Test;

import com.java8.test.lambda.Employee;
 

/*
 * 终止操作
 * 
 * 查找与匹配
 * 	allMath --检查是否匹配所有元素
 * 	anyMath --检查是否至少匹配一个元素
 * 	noneMath -- 检查是否没有匹配所有元素
 * 	findFirst -- 返回第一个元素
 * 	findAny -- 返回当前流中的任意元素
 * 	count -- 返回流中元素的总个数
 * 	max -- 返回流中最大值
 * 	min -- 返回流中最小值
 * */
public class TestStreamEND {
	List<Employee> employee = Arrays.asList(
			new Employee("郑三",118,99.99),
			new Employee("小米",312,34.5),
			new Employee("小米",312,34.5),
			new Employee("小米",312,34.5),
			
			new Employee("西西",39,34.5));
	
	@Test
	public void test(){
		Optional<Employee> op = employee.stream()
				.sorted((e1,e2) -> -Double.compare(e1.getSalary(), e2.getSalary()))
				.findFirst();
		 System.out.println(op.get());
	}
	/*
	 * 规约
	 * 	reduce(T identity,BinaryOperator) 
	 * 	reduce(BinaryOperator) 
	 * 	可以将流中元素反复结合起来，得到一个值。
	 * */
	@Test
	public void tes3(){
		List<Integer> list = Arrays.asList(1,3,5,6,7);
		Integer sum = list.stream()
			.reduce(1, (x,y) -> x + y);
		System.out.println(sum);
		
		Optional<Double> op = employee.stream()
				.map(Employee::getSalary)
				.reduce(Double::sum);
		System.out.println(op.get());
	}
	/*
	 * 收集
	 * 	 collect -- 将流转换为其他形式。接收一个Collector接口的实现，用于给Stream中元素做汇总的方法
	 * */
	@Test
	public void test4(){
		List<String> list = employee.stream()
				.map(Employee::getName)
				.collect(Collectors.toList());
		 list.forEach(System.out::println);
		 System.out.println("放到特殊的集合中-----");
		 HashSet<String> hs = employee.stream()
				 					.map(Employee::getName)
				 					.collect(Collectors.toCollection(HashSet::new));
		 hs.forEach(System.out::println);
	}
	
	@Test
	public void test5(){
		//总数
		Long count = employee.stream()
				.collect(Collectors.counting());
	   System.out.println(count);
	   
	   //平均值
	  Double avg =  employee.stream()
	   			.collect(Collectors.averagingDouble(Employee::getSalary)); 
	   System.out.println(avg);	 
	   
	   //总和    (最大值   ，最小值   ）
	   Double sum =  employee.stream()
	   				.collect(Collectors.summingDouble(Employee::getSalary));
	   System.out.println(sum);
	   
	   //分组
	  Map<String,List<Employee>> map =  employee.stream()
	   			.collect(Collectors.groupingBy(Employee::getName));
	  System.out.println(map);
	   
	  //分区
	  Map<Boolean,List<Employee>> map1 = employee.stream()
	  			.collect(Collectors.partitioningBy((e) -> e.getSalary() >50));
	  System.out.println(map1);
	  
	  DoubleSummaryStatistics dss  =  employee.stream()
	  			.collect(Collectors.summarizingDouble(Employee::getSalary));
	  System.out.println(dss.getMin());
	  
	  String str = employee.stream()
	  		.map(Employee::getName)
            .collect(Collectors.joining("-","==","++"));
	  System.out.println(str);
	}
}








