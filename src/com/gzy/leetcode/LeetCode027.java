package com.gzy.leetcode;

public class LeetCode027 {
	
	public static void main(String[] args) {
		int[] nums = {3,2,2,3,1,5,9,3,4,6,7};
		LeetCode027 lc = new LeetCode027();
		int len = lc.removeElement(nums, 3);
		System.out.println(len);
		for(int i = 0; i < len; i++){
			System.out.print(nums[i] + " ");
		}
	}

	public int removeElement(int[] nums, int val) {
		int len = 0;
		for(int i = 0; i < nums.length; i++){
			if(nums[i] != val){
				nums[len++] = nums[i];
			}
		}
		return len++;
	}
}
