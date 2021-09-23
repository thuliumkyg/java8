package com.juc.c_018_00_AtimicXXX;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class T13_TestLockSupport {

	public static void main(String[] args) {
		Thread t = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				System.out.println(i);
				if (i == 5) {
					//使用LockSupport的 park() 方法阻塞当前线程t
					LockSupport.park();
				}
				
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) { 
					e.printStackTrace();
				};
				
			}
		});
		t.start();
		
		//唤醒线程t
		LockSupport.unpark(t);
		//在线程t 还没有被阻塞的时候， 已经调用了 LockSupport的unpark()方法来唤醒t
		//自后才调用LockSupport的park()来使线程t阻塞，但t并没有被阻塞
		//有此可以看出 LockSupport的unpark()方法可以先于LockSupport的park()方法执行
		
	}
}
