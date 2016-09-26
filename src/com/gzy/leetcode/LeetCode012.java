package com.gzy.leetcode;

import java.util.Date;

public class LeetCode012 {

	public static void main(String[] args) {
		int num = 3895;
		int[] nums = new int[(num + "").length()];
//		int2Array(num, nums);
		LeetCode012 lc = new LeetCode012();
		long begin_time = new Date().getTime();
		for(int i = 1; i < 4000; i++){
			String res = lc.intToRoman(i);
			System.out.println("----------");
			System.out.println(res);			
		}
		long end_time = new Date().getTime();
		System.out.println(end_time-begin_time);
	}

	public String intToRoman(int num) {
		String roman_num = "";
		int len = String.valueOf(num).length();
		String[][] base= {{"0","M"},{"D","C"},{"L","X"},{"V","I"}};
		
		int[] nums = new int[len];
		int dif = 4 - len;
		this.int2Array(num, nums);
		for(int i = 0; i < len; i++){
				if(nums[i] <= 5){
					if(nums[i] == 5){
						roman_num += base[i+dif][0];
					}else if(nums[i] == 4){
						roman_num += base[i+dif][1];
						roman_num += base[i+dif][0];
					}else{
						for(int j = 0; j < nums[i]; j++){
							roman_num += base[i+dif][1];						
						}						
					}
				}else{
					if(nums[i] == 9){
						roman_num += base[i+dif][1];
						roman_num += base[i-1+dif][1];
					}else{
						roman_num += base[i+dif][0];
						for(int j = 0; j < nums[i]%5; j++){
							roman_num += base[i+dif][1];
						}
					}
				}
		}
		return roman_num;
	}

	public void int2Array(int num, int[] nums) {
		int len = nums.length;
		for (int i = len - 1; i >= 0; i--) {
			nums[i] = num % 10;
			num /= 10;
		}
		LeetCodeUtil.printIntegerArray(nums);
	}
}
