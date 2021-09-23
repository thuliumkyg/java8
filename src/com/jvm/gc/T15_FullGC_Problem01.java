package com.jvm.gc;

import java.math.BigDecimal; 
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.sound.midi.MidiDevice.Info;

public class T15_FullGC_Problem01 {

	private static class CardInfo{
		BigDecimal price = new BigDecimal(0.0);
		String name = "����";
		int age = 5;
		Date birthdate = new Date();
		public void m() {
			
		}
		
	}
	private static ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(50,
			new ThreadPoolExecutor.DiscardOldestPolicy());
	
	public static void main(String[] args) throws InterruptedException {
		executor.setMaximumPoolSize(50);
		for(;;) {
			modelFit();
			Thread.sleep(100);
		}
	}
	
	private static void modelFit(){
		List<CardInfo> taskList = getAllCardInfo();
		taskList.forEach(Info -> {
			executor.scheduleWithFixedDelay(() -> {
				Info.m();
			}, 2, 3, TimeUnit.SECONDS);
		});
	}
	
	private static List<CardInfo> getAllCardInfo(){
		List<CardInfo> taskList = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			CardInfo cInfo = new CardInfo();
			taskList.add(cInfo);
		}
		
		return taskList;
	}
	
	
}
