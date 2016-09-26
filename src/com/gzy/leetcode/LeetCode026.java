package com.gzy.leetcode;

public class LeetCode026 {

	public static void main(String[] args) {
		int[] nums = {1,2,2,3,4,4};
		LeetCode026 lc = new LeetCode026();
		int len = lc.removeDuplicates(nums);
		System.out.println(len);
	}
	
	public int removeDuplicates(int[] nums) {
		if(nums.length == 0) return 0;
		int t = 0;
		int len = 0;
		for(int i = 1; i < nums.length;i++){
			if(nums[t] != nums[i]){
				len++;
				nums[len] = nums[i];
				t=i;
			}			
		}
	//	if(t == nums.length -1) len++;
		return len+1;
	}
}
