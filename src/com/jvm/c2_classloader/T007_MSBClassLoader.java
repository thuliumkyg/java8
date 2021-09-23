package com.jvm.c2_classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.crypto.SealedObject;
import javax.tools.FileObject;

import com.jvm.Hello;

//自定义类加载器有很多种方法, 最简单的一种     继承ClassLoader
//class加密     异或一下加密  异或一下解密
public class T007_MSBClassLoader extends ClassLoader{

	//
	public static int seed = 0B10110110;
	
	//重写findClass方法,然后找到要load进来的二进制内容. load完之后再转换成对象
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		File file = new File("G:/jee-ecl/Java8/bin/", name.replace(".", "/").concat(".msbclass")); 
		try {
			FileInputStream fis = new FileInputStream(file);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int b = 0;
			while ((b=fis.read()) != 0) {
				 baos.write(b ^ seed); 
			}
			byte[] bytes = baos.toByteArray();
			baos.close();
			fis.close();
			return defineClass(name, bytes, 0, bytes.length);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return super.findClass(name);
	}
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
		encFile("com.jvm.Hello");
		
		ClassLoader l = new T007_MSBClassLoader();
		Class clazz = l.loadClass("com.jvm.Hello");
		Class clazz1 = l.loadClass("com.jvm.Hello");
		System.out.println(clazz == clazz1);
		
		Hello hello = (Hello)clazz.newInstance();
		hello.m();
		
		//是AppClassLoader
		System.out.println(l.getClass().getClassLoader());
		System.out.println(l.getParent());
		System.out.println(getSystemClassLoader());
		
	}
	
	private static void encFile(String name) throws IOException{
		File file = new File("G:/jee-ecl/Java8/bin/", name.replace(".", "/").concat(".class")); 
		FileInputStream fis = new FileInputStream(file);
		FileOutputStream fos = new FileOutputStream(new File("G:/jee-ecl/Java8/bin/", name.replaceAll("\\.", "/").concat(".msbclass")));
				
		int b = 0;
		while ((b = fis.read()) != -1) {
			 fos.write(b ^ seed); 
		}
		
		fis.close();
		fos.close();
	}
}
