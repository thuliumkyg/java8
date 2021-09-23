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
		 * û�м�ͬ��
		 * while(true) c.size()������Զû�м�⵽����Ϊ�߳����߳�֮���ǲ��ɼ���
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
			System.out.println("t2����");
		}, "t2").start();
		
	}
	
	
}
