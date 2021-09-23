package com.jvm.c2_classloader;

public class T0011_ClassReloading1 {
	
	public static void main(String[] args) throws ClassNotFoundException {
		T006_MSBClassLoader msbClassLoader = new T006_MSBClassLoader();
		Class clazz = msbClassLoader.loadClass("com.jvm.Hello");
		
		msbClassLoader = null;
		System.out.println(clazz.hashCode());
		//第一个classloader 设为空
		msbClassLoader = null;
		//在new一个classloader
		msbClassLoader = new T006_MSBClassLoader();
		//在new同样的一个class
		Class clazz1 = msbClassLoader.loadClass("com.jvm.Hello");
		System.out.println(clazz1.hashCode());
		//两个class是否相等？，     true :双亲委派。不管怎么样操作，他都会让父亲去找，找到了就不会去重新加载
		System.out.println(clazz == clazz1);
		
	}
	
	
}
