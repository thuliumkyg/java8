package com.java8.test.lambda2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import org.junit.Test;

import com.java8.test.lambda.Employee; 

/*一.Lambda 表达式的基础语法：
  * 	Java8 中引入了一个新的操作符 “->" 该操作符称为箭头操作符或Lambda操作符 
  * 		箭头操作符称Lambda 表达式拆分成两部分；
  * 	左侧：Lambda 表达式的参数列表
  * 	右侧 ：Lambda 表达式中所需执行的功能，即Lambda 体
  *   
  *   语法格式一：无参数，无返回值
  *   				（）-> System.out.println("hello");;
  *   语法格式二：有参数，无返回值
  *    			        （x）-> System.out.println(x);
  *   语法格式三：若只有一个参数，小括号可以省略不写
  *   				  x -> System.out.println(x);
  *   语法格式四：有两个以上参数，有返回值，并且Lambda 体中有多条语句
  *   				  Comparator<Integer> com = (x,y) ->{
						 System.out.println("函数式接口");
						 return Integer.compare(x, y);
					  };
  *   语法格式五：若Lambda 体中只有一条语句，return 和大括号都可以省略不写
  *   语法格式六： Lambda 表达式的参数列表类型可以不写，
  *   				因为JVM编译器通过上下文推断出	数据类型，即“类型推断”
  *
  *二、 Lambda 表达式需要“函数式接口”的支持
  *		函数式接口：接口中只有一个抽象方法的接口，称为函数式接口。
  *					可以使用注解 @FunctionalInterface 修饰可以检查是否是函数式接口
  * */
public class TestLambda {

	@Test
	public void test1(){
		int num = 0;  //jdk1.7 必须是final
		
		Runnable r = new Runnable(){  
			@Override
			public void run() {
				System.out.println("Hellow Lambda  " +  num); 
				
			}
			
		};
		r.run();
		
		System.out.println("-----");
		
		Runnable r1 = () -> System.out.println("Hellow Lambda");
		r1.run();
	}
	
	@Test
	public void test2(){
		Consumer<String> con = x -> System.out.println(x);
		con.accept("hsfhejjj");
	}
	
	@Test
	public void test3(){
		Comparator<Integer> com = (x,y) ->{
			System.out.println("函数式接口");
			return Integer.compare(x, y);
		};
	}
	
	@Test
	public void test4(){
		Comparator<Integer> com = (x,y) ->  Integer.compare(x, y);
		 
	}
	
	@Test
	public void test5(){
		//类型推断
		String[] strs = {"aa","bb","ccc"};
		List<String> list = new ArrayList<>();
			
	}
	
	//需求：对一个数进行运算
	@Test
	public void test6(){
		Integer num = operation(100, (x) -> x * x ) ;
		System.out.println("num:"+num);
	}
	
	public Integer operation(Integer num ,MyFun mf){
		return mf.getValue(num);
	}
	
	List<Employee> employee = Arrays.asList(
			new Employee("郑三",118,99.99),
			new Employee("小米",312,34.5),
			new Employee("小米",39,34.5));
	@Test 
	public void test11(){
		Collections.sort(  employee,(e1,e2) -> {
			if(e1.getAge() == e2.getAge()){
				return e1.getName().compareTo(e2.getName());
			}else{
				return Integer.compare(e1.getAge(), e2.getAge());
			}
		});
		
		for(Employee emp : employee){
			System.out.println(emp);
		}
		String upper = strHandler("abfehh", (e) -> e.toUpperCase());
		System.out.println(upper);
		
		String upper1 = strHandler("serrerertff", (st) -> st.substring(2,5));
		System.out.println(upper1);
	
	}
	
	public String strHandler(String str, MyFunction mf){
		return mf.getValue(str);
	}
}
