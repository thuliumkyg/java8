package com.java8.test.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import org.junit.Test;

public class TestLambda {
	
	//匿名内部类
	@Test
	public void test1(){
		Comparator<Integer> com = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1, o2);
			}
		};
		
		TreeSet<Integer> ts = new TreeSet<>(com);
	}
	
	//Lambda  表达式
	@Test
	public void test2(){
		Comparator<Integer> com = (x,y) -> Integer.compare(x, y);
		TreeSet<Integer> ts = new TreeSet<>(com);
	}
	
	List<Employee> employee = Arrays.asList(
			new Employee("郑三",118,99.99),
			new Employee("小米",312,34.5),
			new Employee("小米",39,34.5));
	
	//需求： 获取当前公司中员工年龄大于35的员工信息
	@Test
	public void test3(){
		List<Employee> list = filterEmployee(employee);
		for(Employee emp : list){
			System.out.println(emp);
		}
		
	}
	public List<Employee> filterEmployee(List<Employee> list  ){
		List<Employee> emps = new ArrayList<>();
		for(Employee emp : list){
			if(emp.getAge() >= 35){
				emps.add(emp);
			}
		}
		
		return emps;
	}
	
	//优化方式一 ：策略设计模式
	public List<Employee> filterEmployee1(List<Employee> list , MyPredicate<Employee> myPredicate){
		  List<Employee>  emps = new ArrayList<>();
		  for(Employee employee: list ){
			  if(myPredicate.test(employee)){
				  emps.add(employee);
			  }
		  }
		  
		  return emps;
	}
	 
    //优化方式二： 匿名内部类
	@Test
	public void test5(){
		List<Employee> list = filterEmployee1(employee, new MyPredicate<Employee>() {

			@Override
			public boolean test(Employee t) {
				 
				return  t.getAge() >= 35;
			}
		   
		});
		
		for(Employee employee : list){
			System.out.println(employee);
		}
	}
	
	//优化方案三： Lambda 表达式
	@Test
	public void test6(){
		List<Employee> list = filterEmployee1(employee,(e) -> e.getAge() >= 35);
	    
		list.forEach(System.out::println);
		 
	}
	
	//优化方式四： Stream API
	@Test
	public void test7(){
		employee.stream().filter((e) -> e.getAge() >= 35)
		.limit(2).forEach(System.out::println);
		
		
		System.out.println("------");
		
		employee.stream().map(Employee::getAge).forEach(System.out::println);
	}
	
	
	
	
	
}
