package com.jvm.c2_classloader;

public class T01_CacheLinePadding {
	private static class T{
		//创建了一个T类     一个long类型的x8个字节
		public volatile long x = 0L;
	}
	
	//弄了一个T类型数组
	public static T[] arr = new T[2];
	//静态初始化完成之后，内存里面有两个数组， 这两个数组里面指向的是new来的对象， 里面就只有一个8个字节long类型
	static{
		arr[0] = new T();
		arr[1] = new T();
	}
	
	//这个时候启动两个线程
	public static void main(String[] args) throws InterruptedException {
		//第一个线程，循环一百万次， 让x值不断产生变化， 刚好两个值位于一个缓存行，有正好位于一个cpu, 那就会发生第一个cpu和第二个cpu不断的更新缓存行
		Thread t1 = new Thread(() -> {
			for (long i = 0; i < 1000_0000L; i++){
				arr[0].x = i;
			}
		});
		Thread t2 = new Thread(() -> {
			for (long i = 0; i < 1000_0000L; i++){
				arr[1].x = i;
			}
		});
		
		final long start = System.nanoTime();
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(System.nanoTime() - start); //276403900
	}

}
