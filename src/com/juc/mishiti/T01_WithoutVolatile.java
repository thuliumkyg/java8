package com.juc.mishiti;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class T01_WithoutVolatile {

	List lists = new ArrayList();
	public void add(Object o) {
		lists.add(o);
	}
	
	public int size() {
		return lists.size();
	}
	
	
	public static void main(String[] args) {
		/**
		 * 没有加同步
		 * while(true) c.size()方法永远没有检测到，因为线程与线程之间是不可见的
		 */
		T01_WithoutVolatile c = new T01_WithoutVolatile();
		new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				c.add(new Object());
				System.out.println("add" + i);
				
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, "t1").start();
		
		new Thread(() -> {
			while (true) {
				//System.out.println("t2:c.size--" + c.size());
			 	if(c.size() == 5) {
					
					break;
				}
				
			}
			System.out.println("t2结束");
		}, "t2").start();
		
	}
	
	
}
