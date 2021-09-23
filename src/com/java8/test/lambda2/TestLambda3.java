package com.java8.test.lambda2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

/*
*  Java8 ���õ��Ĵ���ĺ���ʽ�ӿ�
*  		Consumer<T> :�����ͽӿ�
*  					 void accept(T t);
*  		Supplier<T> : �����ͽӿ�
*  						T get����;
*  		Function<T ,R> :�����ͽӿ�
*  						R apply(T t����
*  		Predicate<T> : �����ͽӿ�
*  						boolean test(T t);
*
*/
public class TestLambda3 {
	//Predicate<T> :�����ͺ���
	@Test
	public void test4(){
		List<String> list = Arrays.asList("hello","ajjjej","ddf","ss");
		List<String> strList = filterStr(list, (s) ->s.length() > 3 );
		for (String string : strList) {
			System.out.println(string);
		}
	}
	//���� ָ���ַ�����ӵ�������
	public List<String> filterStr(List<String> list,Predicate<String> pre){
		List<String> strList = new ArrayList<>();
		for(String str : list){
			 if(pre.test(str)){
				 strList.add(str);
			 }
		}
		return strList;
	}
	
	
	//Function<T,R> �����ͽӿڣ�
    @Test
    public void test3(){
    	String newStr  = strHandler("dsfje/t/t  ", (str) -> str.trim());
    	System.out.println(newStr);
    }
    public String strHandler(String str, Function<String,String> fun){
       return	fun.apply(str);
    }
	
	//Supplier<T> �����ͽӿڣ�
	@Test
	public void test2(){
		List<Integer> numList = getNumList(10, () -> (int)(Math.random() * 100));
	    for (Integer num : numList) {
			System.out.println(num);
		}
	   
	}
	//���󣺲���ָ�������������ŵ�������
	public List<Integer> getNumList(int num, Supplier<Integer> sup){
		List<Integer> list = new ArrayList<>();
		for(int i = 0 ;i<num;i++){
			Integer n = sup.get();
			list.add(n);
		}
		
		return list;
	}
	
	//Consumer<T> �����ͽӿ�:
	@Test
	public void test1(){
		happy(10000, (m) -> System.out.println("����:"+m));
	}
	public void happy(double money,Consumer<Double> con){
		con.accept(money);
	}

}
