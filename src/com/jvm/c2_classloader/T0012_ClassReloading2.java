package com.jvm.c2_classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.hamcrest.core.Is;
import org.xml.sax.InputSource;

public class T0012_ClassReloading2 {
	
	//定义自己新的classlocader， 从classloader继承
	private static class  MyLocader extends ClassLoader {
		//重写findClass方法,然后找到要load进来的二进制内容. load完之后再转换成对象
		@Override
		public Class<?> loadClass(String name) throws ClassNotFoundException {
			File file = new File("G:/jee-ecl/Java8/bin/", name.replace(".", "/").concat(".class")); 
			
			if (!file.exists()) return super.loadClass(name);
			
			try {
				InputStream fis = new FileInputStream(file);
				byte[] b = new byte[fis.available()];
				fis.read(b);
				 
				return defineClass(name, b, 0, b.length);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return super.findClass(name);
		}
		
	}
	
	//所以tomcat这么干， 直接webapplication的整个classloader 全部干掉， 重新再加载一遍
	public static void main(String[] args) throws ClassNotFoundException {
		MyLocader m = new MyLocader();
		Class clazz =  m.loadClass("com.jvm.Hello");
		
		m = new MyLocader();
		Class clazzNew = m.loadClass("com.jvm.Hello");
		
		System.out.println(clazz == clazzNew);
	}

}
