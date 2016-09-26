package com.gzy.leetcode;

public class LeetCode338 {
	public static void main(String[] args) {
		new LeetCode338().countBits(5);
	}

	public int[] countBits(int num) {
		int[] nums = new int[num+1];
		int j = 0;
		for(int i = 0; i < num + 1; i++){
			int t = i;
			int temp = t, count = 0;
			while(temp != 0){
				if(temp%2==1) count++;
				temp /= 2;
			}
			nums[j++] = count;
		}
		LeetCodeUtil.printIntegerArray(nums);
		return nums;
	}
}
