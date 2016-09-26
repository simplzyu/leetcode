package com.gzy.leetcode;

public class LeetCode066 {
	public static void main(String[] args) {
		int[] digits = {9,9};
		LeetCode066 lc = new LeetCode066();
		digits = lc.plusOne(digits);
		lc.printArray(digits);
	}

	public int[] plusOne(int[] digits) {
		int len = digits.length;
		int num,udig,ddig=0;
		digits[len-1] += 1;
		for(int i = len-1; i >=0; i--){
			num = digits[i];
			udig = num%10;
			digits[i] = udig;
			ddig = num/10;
			if(i == 0) break;
			digits[i-1] = digits[i-1] + ddig;
		}
		if(ddig!=0){
			int[] a = new int[len+1];
			a[0] = ddig;
			for(int i = 1; i < len +1; i++)
				a[i] = digits[i-1];
			return a;
		}else
			return digits;
	}
	
	public void printArray(int[] digits){
		for(int i = 0; i < digits.length; i++)
			System.out.println(digits[i]);
	}
}
