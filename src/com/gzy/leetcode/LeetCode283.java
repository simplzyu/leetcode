package com.gzy.leetcode;

public class LeetCode283 {
	public static void main(String[] args) {
		int[] nums = {0, 1, 0, 3, 12};
		new LeetCode283().moveZeroes(nums);
		LeetCodeUtil.printIntegerArray(nums);
	}

	public void moveZeroes(int[] nums) {
		int[] temp = new int[nums.length];
		int t = 0;
		for(int i = 0; i < nums.length; i++){
			if(nums[i] != 0){
				temp[t] = nums[i];
				t++;
			}
		}
		for(int i = 0; i < t; i++){
			nums[i] = temp[i];
		}
		for(int i = t; i < nums.length; i++){
			nums[i] = 0;
		}
	}
}
