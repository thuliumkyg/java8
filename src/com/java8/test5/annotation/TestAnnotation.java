package com.java8.test5.annotation;

import java.lang.reflect.Method;

import org.junit.Test;

/*
	重复注解与 类型注解
*/

public class TestAnnotation {
	//checker formaker
    //不能为空  可以设计一个注解  @NonNull  ，java8 还没有内置次类型注解
	private  Object obj = null;
	@Test
	public void test1() throws  Exception{
		Class<TestAnnotation> clazz = TestAnnotation.class;
		Method m1 = clazz.getMethod("show");
		MyAnnotation[]  ma = m1.getAnnotationsByType(MyAnnotation.class);
	    for(MyAnnotation myAnnotation : ma){
	    	System.out.println(myAnnotation.value());
	    }
	}
	
	@MyAnnotation("word")
	@MyAnnotation("hello")
	public void show(@MyAnnotation("abc") String str){
		
	}
}
