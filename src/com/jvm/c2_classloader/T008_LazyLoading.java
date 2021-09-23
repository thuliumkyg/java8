package com.jvm.c2_classloader;

public class T008_LazyLoading {

	//严格讲应该叫laz initialzing  因为java虚拟机规范并没有严格规定什么时候
	//必须loading  但严格规定了什么时候initialzing
	public static void main(String[] args) throws ClassNotFoundException {
		//没有new 没有访问不会被加载
		//P p;
		
		//new 了会被加载
		//X x = new  X();
		
		//打印final 值不需要加载整个类
		//System.out.println(P.i);
		
		//非final他会加载
		//System.out.println(P.j);
		
		//会被加载
		Class.forName("com.jvm.c2_classloader.T008_LazyLoading$P");
	}
	
	public static class P {
		final static int i = 8;
		static int j = 9;
		static {
			//只要被加载过这个P一定是被打印出来的，因为一个classload 内存之后他有这几个步骤
			//1 Loading
			//2 Linking
			//3 Initlalizing 这个过程会执行静态语句块， 所有被load进来这个语句块一定被执行过，
			//p一旦打印就证明这个class被load进来
			System.out.println("P");
		}
	}
	
	public static class X extends P {
		static {
			System.out.println("X");
		}
	}
}
