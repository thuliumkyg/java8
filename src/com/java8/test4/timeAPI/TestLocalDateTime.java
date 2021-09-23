package com.java8.test4.timeAPI;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

import org.junit.Test;

public class TestLocalDateTime {
	
	//Instant :时间戳   （以Unix 元年： 1970年1月1日 00：00：00到某个时间之间的毫秒值）
	          //获取毫秒：toMilli()    秒：getSeconds()
	@Test
	public void test(){
		Instant ins1 = Instant.now() ; //默认获取UTC 时区   和中国差8个小时时差
		System.out.println(ins1);
		System.out.println(ins1.toEpochMilli());
		//代偏移量运算
		OffsetDateTime odt = ins1.atOffset(ZoneOffset.ofHours(8));
		System.out.println(odt);
	}
	
	//Duration  : 计算两个“时间”之间的间隔
	//Period : 计算两个“日期”之间的间隔
	@Test
	public void tes2(){
		Instant ins1 = Instant.now();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Instant ins2 = Instant.now();
		
		Duration duration = Duration.between(ins1, ins2);
		System.out.println(duration.toMillis());
		
		LocalTime lt1 = LocalTime.now();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		LocalTime lt2 = LocalTime.now();
		System.out.println(Duration.between(lt1, lt2));
	}
	
	@Test
	public void test3(){
		LocalDate ld = LocalDate.of(2016, 11, 22);
		LocalDate ld2 = LocalDate.now();
		
		Period period = Period.between(ld, ld2);
		System.out.println(period.getYears()+"--"+period.getMonths()+"--"+period.getDays());
	}
	
	//TemporalAdjuster : 时间矫正器
	@Test
	public void test5(){
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
		//指定 
		LocalDateTime ldt2 = ldt.withDayOfMonth(10);
		System.out.println(ldt2);
		//偏移
		LocalDateTime ldt3 = ldt.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
	    System.out.println(ldt3);
	    //自定义：下一个工作日
	   LocalDateTime ldt5 =  ldt.with((l) -> {
	    	LocalDateTime ldt4 = (LocalDateTime) l;
	    	DayOfWeek dow = ldt4.getDayOfWeek();
	    	
	    	if(dow.equals(DayOfWeek.WEDNESDAY)){
	    		return ldt4.plusDays(3);
	    	}else{
	    		return ldt4.minusDays(3);
	    	}
	    	 
	    });
	   
	   System.out.println(ldt5);
	}
	
	//DateTimeFormatter : 格式化时间/日期
	@Test
	public void tets6(){
	 	DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE_TIME;
		LocalDateTime ldt = LocalDateTime.now();
		String string = ldt.format(dtf);
		System.out.println(string);
		
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy年MM月dd日  HH:mm:ss");
		String str2 = dtf2.format(ldt);
		System.out.println(str2);
	}
	//ZonedDate  ZonedTime  ZonedDateTime
	@Test
	public void test4(){
		/*Set<String> set = ZoneId.getAvailableZoneIds();
		set.forEach(System.out::println);*/
		LocalDateTime ldt = LocalDateTime.now(ZoneId.of("Europe/Tallinn"));
		System.out.println(ldt);
		//带时区的时间格式
		ZonedDateTime zdt = ldt.atZone(ZoneId.of("Asia/Shanghai"));
		System.out.println(zdt);
	}
	
	
}
