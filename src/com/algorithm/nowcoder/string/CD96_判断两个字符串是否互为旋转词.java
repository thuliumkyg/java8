package com.algorithm.nowcoder.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CD96_�ж������ַ����Ƿ�Ϊ��ת�� {
	//	��Ŀ����
	//	���һ���ַ���Ϊstr�����ַ�����ǰ�����ⲿ��Ų�������γɵ��ַ�����str����ת�ʡ�����str=��12345����str����ת���С�12345������45123���ȵȡ����������ַ������ж��Ƿ�Ϊ��ת�ʡ�
	//	��������:
	//		����������У���һ����������n��m��1 \leq n,m \leq10^5 ����1��n,m��105�����ֱ��ʾ�����ַ����ĳ��ȡ��ڶ��к͵����и�����һ���ַ�����
	//	�������:
	//		��������ַ�����Ϊ��ת���������YES�������������NO����
	
	//	ʾ��1
	//		���� 
	//			4 4
	//			abcd
	//			cdab
	//		��� 
	//			YES
	
	 public static void main(String[] args) throws IOException {
	        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	        String[] strings=br.readLine().split(" ");
	        int n=Integer.parseInt(strings[0]);
	        int m=Integer.parseInt(strings[1]);
	        String str1=br.readLine();
	        String str2=br.readLine();
	        if(n!=m){
	            System.out.println("NO");
	            return ;
	        }
	        System.out.println(isDeformation(str1,str2)?"YES":"NO");
	    }
	    public static boolean isDeformation(String str1,String str2) {
	        String string=str1+str1;
	        return (string.indexOf(str2)!=-1);
	    }

}
