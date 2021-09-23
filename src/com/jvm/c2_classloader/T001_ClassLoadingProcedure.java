package com.jvm.c2_classloader;

public class T001_ClassLoadingProcedure {

	public static void main(String[] args) {
		
		//count 在上是3，  当调用T
		//先把T classload 内存
		//进行Verification校验，
		//然后进行Preparation赋默认值这时候: T=0空值，
		//继续进行Resolution,
		//在进行Initializing 初始化给赋初始值，这个时候 count=2、然后会调用new T T() count++ 变成3
		
		//T在上 是2    当调用T先把T classload内存进行Verification校验，
		//然后进行Preparation 赋默认值这个时候T是0空值，count是0 继续进行Resolution,  
		//在进行Initializing初始化给赋初始值，先调用new T T() count++ 0变成1， 然后赋值为2， 最后结果为2
		
		System.out.println(T.count);
	}
	
	
}

class T {
	
	public static int count = 2;
	public static T t =  new T();
	//public static int count = 2;
	
	private int m = 8;
	
	private T() {
		count ++;
		System.out.println("--" + count);
	}
}