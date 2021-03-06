package com.juc.c_018_00_AtimicXXX;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.ProgressMonitorInputStream;
import javax.swing.text.StyledEditorKit.ForegroundAction;

public class T01_AtomicInteger {

	AtomicInteger count = new AtomicInteger(0);
	
	void m() {
		for (int i = 0; i < 10000; i++) {
			count.incrementAndGet();
		}
		
	}
	
    public static void main(String[] args) {
		T01_AtomicInteger t = new T01_AtomicInteger();
		List<Thread> threads = new ArrayList<Thread>();
		for (int i =0; i < 10; i++) {
			threads.add(new Thread(t::m, "Thread-" + i));
		}
		
		threads.forEach((o) -> o.start());
		
		threads.forEach((o) -> {
			try {
				o.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		System.out.println(t.count);
	}
	
	
}
