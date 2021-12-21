package com.java8.test.lambda.lambda2;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import com.java8.test.lambda.lambda.Employee;
import org.junit.Test;


/*
 * �������ã���Lambda ���е������з����Ѿ�ʵ���ˣ����ǿ���ʹ�á���������"
 * 			(����������Lambda ���ʽ������һ�ֱ��֣�
 * ��Ҫ�������﷨��ʽ��
 * 			���󣺣�ʵ��������
 * 			�ࣺ�� ��̬������
 * 			�ࣺ��ʵ��������
 *  ע�⣺ Lambda ���е��÷����Ĳ����б��뷵��ֵ���ͣ�Ҫ�뺯��ʽ�ӿ��г��󷽷��ĺ����б�ͷ���ֵ���ͱ���һ�£�
 *        ��Lambda �����б��еĵ�һ��������ʵ�������ĵ����ߣ����ڶ���������ʵ�������Ĳ���ʱ������ʹ��ClassName ���� method
 * 
 * ���������ã�
 * 			��ʽ��  ClassName ����new
 *   ע�⣺��Ҫ���õĹ������Ĳ����б�Ҫ�뺯��ʽ�ӿ��еĳ��󷽷��Ĳ����б���һ�£�
 * 
 * �������ã� 
 * 			��ʽ�� Type::new 
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
		
		//���������÷�ʽ
		Supplier<Employee> sup2 = Employee::new;
		System.out.println(sup2.get());
		
		//һ�������Ĺ�����
		Function<String, Employee> fun = Employee::new;
		System.out.println(fun.apply("С����"));
		
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
