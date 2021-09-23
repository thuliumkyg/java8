package com.jvm.c2_classloader;
 

public class T01_CacheLinePadding2 {
	
	private static class Padding{
		//创建 7个long类型的数
		public volatile long p1,p2,p3,p4,p5,p6,p7;
	}

	//从padding继承， 就会发生我前面我先占了56个字节， 然后我会把我自己的这个存到后面， 所以这个我自己就占了一行， 所以另一个绝对不会在一个行里，这样效率就高了
	private static class T extends Padding{
		//创建了一个T类     一个long类型的x8个字节
		public volatile long x = 0L;
	}
	
	//弄了一个T类型数组
	public static T[] arr = new T[2];
	 
	static{
		arr[0] = new T();
		arr[1] = new T();
	}
	
	//这个时候启动两个线程
	public static void main(String[] args) throws InterruptedException {
		//第一个线程，循环一百万次， 让x值不断产生变化， 刚好两个值位于一个缓存行，想办法不让他位于一个缓存行， 这个理论上会比第一个效率高
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
		System.out.println(System.nanoTime() - start); //74803700
	}
}
