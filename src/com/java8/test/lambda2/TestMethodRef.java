package com.java8.test.lambda2;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.Test;

import com.java8.test.lambda.Employee;
 

/*
 * 方法引用：若Lambda 体中的内容有方法已经实现了，我们可以使用“方法引用"
 * 			(方法引用是Lambda 表达式的另外一种表现）
 * 主要有三种语法格式：
 * 			对象：：实例方法名
 * 			类：： 静态方法名
 * 			类：：实例方法名
 *  注意： Lambda 体中调用方法的参数列表与返回值类型，要与函数式接口中抽象方法的函数列表和返回值类型保持一致！
 *        若Lambda 参数列表中的第一个参数是实例方法的调用者，而第二个参数是实例方法的参数时，可以使用ClassName ：： method
 * 
 * 构造器引用：
 * 			格式：  ClassName ：：new
 *   注意：需要调用的构造器的参数列表要与函数式接口中的抽象方法的参数列表保持一致！
 * 
 * 数组引用： 
 * 			格式： Type::new 
 * 
 * */
public class TestMethodRef {

	@Test
	public void test3(){
		Function<Integer, String[]> fun = (x) ->new  String[x];
		String[] strs = fun.apply(10);
		System.out.println(strs.length);
		
		Function<Integer,String[]> fun1 = String[]::new;
		String[] strs2 = fun1.apply(20);
		System.out.println(strs2.length);
	}
	@Test 
	public void test2(){
		Supplier<Employee> sup = () -> new Employee();
		Employee em = sup.get();
		
		//构造器引用方式
		Supplier<Employee> sup2 = Employee::new;
		System.out.println(sup2.get());
		
		//一个参数的构造器
		Function<String,Employee> fun = Employee::new;
		System.out.println(fun.apply("小星星"));
		
	}
	
	@Test
	public void test1(){
		Consumer<String> con = (x) ->  System.out.println(x);
		
		PrintStream ps = System.out;
		Consumer<String> con1 = ps::println;
		con1.accept("abcef");
		 
		Comparator<Integer> com = (x,y) -> Integer.compare(x,y);
		Comparator<Integer> com1 =  Integer::compare;
		
		BiPredicate<String, String> bp = (x,y) -> x.equals(y);
		BiPredicate<String, String> bp2 = String::equals;

	}
}
