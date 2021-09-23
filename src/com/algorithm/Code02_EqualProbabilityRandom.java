package com.algorithm;

public class Code02_EqualProbabilityRandom {
	public static void main(String[] args) {
		//给定一个数组，如果有一个数出现次数大于一半，返回这个数，
		//如果没有任何一个数出现次数大于一半，返回 -1
		//要求：时间复杂度O(N), 额外空间复杂度O(1)
		int[] arr = {1,4,4,4,5};
	    int a = halfMajor(arr);
	    System.out.println(a);
	}

	public static int halfMajor(int[] arr) {
		int cand = 0;
		int HP = 0;
		for (int i = 0; i != arr.length; i++) {
			if (HP == 0) {
				cand = arr[i];
				HP = 1;
			} else if (cand == arr[i]) {
				HP++;
			} else {
				HP--;
			}
		}
		if (HP == 0) {
			return -1;
		}
		HP = 0;
		for (int i = 0; i != arr.length; i++) {
			if (arr[i] == cand) {
				HP++;
			}
		}
		
		return HP > arr.length/2 ? cand : -1;

	}
}
