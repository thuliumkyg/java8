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
	
	//�����Լ��µ�classlocader�� ��classloader�̳�
	private static class  MyLocader extends ClassLoader {
		//��дfindClass����,Ȼ���ҵ�Ҫload�����Ķ���������. load��֮����ת���ɶ���
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
	
	//����tomcat��ô�ɣ� ֱ��webapplication������classloader ȫ���ɵ��� �����ټ���һ��
	public static void main(String[] args) throws ClassNotFoundException {
		MyLocader m = new MyLocader();
		Class clazz =  m.loadClass("com.jvm.Hello");
		
		m = new MyLocader();
		Class clazzNew = m.loadClass("com.jvm.Hello");
		
		System.out.println(clazz == clazzNew);
	}

}
