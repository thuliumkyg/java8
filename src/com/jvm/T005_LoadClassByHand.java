package com.jvm;

public class T005_LoadClassByHand {

	public static void main(String[] args) throws ClassNotFoundException {
		Class clazz = T005_LoadClassByHand.class.getClassLoader().loadClass("com.jvm.T003_ClassLocderScope");
		System.out.println(clazz.getName());
	}
}
