package com.juc.mishiti;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class T04_NotifyHoldingLock {

	//添加volatile, 使t2能够得到通知
		volatile List lists = new ArrayList();
		public void add(Object o) {
			lists.add(o);
		}
		
		public int size() {
			return lists.size();
		}
		
		public static void main(String[] args) {
			T04_NotifyHoldingLock c = new T04_NotifyHoldingLock();
			final Object lock = new Object();
			new Thread(() -> {
				synchronized (lock) {
					System.out.println("t2 启动");
					if (c.size() != 5) {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println("t2 结束");
					//通知 t1继续执行
					lock.notifyAll();
				}
				//Exception
//				//通知 t1继续执行
//				lock.notifyAll();
				
			}, "t2").start();
			
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			new Thread(() -> {
				System.out.println("t1 启动");
				synchronized (lock) {
					for (int i = 0; i < 10; i++) {
						c.add(new Object());
						System.out.println("add" + i);
						if (c.size() == 5) {
							lock.notifyAll();
							//释放锁，让t2得以执行
							try {
								lock.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
						try {
							TimeUnit.SECONDS.sleep(1);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}, "t1").start();
		}
}
