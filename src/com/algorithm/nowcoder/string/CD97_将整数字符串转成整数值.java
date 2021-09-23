package com.algorithm.nowcoder.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CD97_�������ַ���ת������ֵ {
	/**
	 * ��Ŀ����
		����һ���ַ���str�����str�����ճ���д��������ʽ����������32λ������Χ������str���������ֵ�����򷵻�0��
		��������:
			�������һ�д���str��1 \leq length(str) \leq 100����1��length(str)��100����
		�������:
			���һ�У������ص�ֵ��
		ʾ��1
			���� 
				123
			��� 
				123
				
			ʾ��2
			���� 
				023
			��� 
				0
	 */
	
	public static void main(String[] args) throws Exception{
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String str=reader.readLine();
        char[] arr=str.toCharArray();
        System.out.print(getNum(arr));
    }
    public static boolean isValid(char[] arr){
        if(arr[0]!='-'&&(arr[0]<'0'||arr[0]>'9')){
            return false;
        }
        if(arr[0]=='-'&&(arr[0]=='0'||arr.length==1)){
            return false;
        }
        if(arr[0]=='0'){
            return false;
        }
        for(int i=1;i<arr.length;i++){
            if(arr[i]<'0'||arr[i]>'9'){
                return false;
            }
        }
        return true;
    }
     
    public static int getNum(char[] arr){
        if(arr==null||arr.length==0){
            return 0;
        }
        if(!isValid(arr)){
            return 0;
        }
        boolean flag=arr[0]=='-'?true:false;//����ʱ���־λΪtrue
        long res=0;
        long cur=0;
        long temp;
        for(int i=flag?1:0;i<arr.length;i++){
            //�ַ�ֵת����ֵ�Ĺ����в���ʹ��Long��valueOf()����
            //ʹ��arr[i]-'0'����ʽ;
            temp=arr[i]-'0';
            res=res*10L+temp;
            cur=flag?-res:res;
            if(cur<Integer.MIN_VALUE||cur>Integer.MAX_VALUE){
               return 0;
            }  
        }
        int res1=(int)res;
        return flag?-res1:res1;   
    }
}
