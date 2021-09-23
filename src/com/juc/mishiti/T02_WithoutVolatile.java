package com.juc.mishiti;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class T02_WithoutVolatile {

	//volatile 修饰 
	/**
	 * volatile 一定要修饰普通值，不要修饰引用值
	 * volatile修饰引用类型，这个引用对象指向的是另外一个new出来的对象，
	 * 这个对象里面的成员变量的值改变了，是无法观察到的
	 */
	volatile List lists = new ArrayList();  
	public void add(Object o) {
		lists.add(o);
	}
	
	public int size() {
		return lists.size();
	}
	
	
	public static void main(String[] args) {
		/**
		 *  
		 *  
		 */
		T01_WithoutVolatile c = new T01_WithoutVolatile();
		new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				c.add(new Object());
				System.out.println("add" + i);
				
				 
			}
		}, "t1").start();
		
		new Thread(() -> {
			while (true) { 
			 	if(c.size() == 5) { 
					break;
				}
				
			}
			System.out.println("t2结束");
		}, "t2").start();
		
	}
	
}
