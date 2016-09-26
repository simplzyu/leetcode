package com.gzy.leetcode;

public class LeetCode011 {

	public static void main(String[] args) {
		LeetCode011 lc = new LeetCode011();
		int[] height = {1,3,1,1};
		System.out.println(lc.maxArea(height));
		
	}

	public  int maxArea(int[] height) {
		if(height.length == 1) return 0;
		Num[] nums = new Num[height.length]; 
		for(int i = 0; i < height.length; i++){
			nums[i] = new Num(i, height[i]);
		}
		boolean flag = true;
		for(int i = 0; i < nums.length && flag; i++){
			flag = false;
			for(int j = nums.length-1; j > i; j--){
				if(nums[j-1].value > nums[j].value){
					Num temp = new Num();
					temp = nums[j-1];
					nums[j-1] = nums[j];
					nums[j] = temp;
					flag = true;
				}
			}
		}
//		int t = 0;
		int left_value = nums[0].value*(nums[0].index-0);
		int right_value = nums[0].value*(nums.length - nums[0].index-1);
		int max = left_value > right_value?left_value:right_value;
//		System.out.println(max);
//		int max = nums[0].value*(nums[1].index-nums[0].index);
//		System.out.println(max);
		for(int i = 1; i < nums.length-1; i++){
			for(int j = i+1; j < nums.length; j++){
				int temp = nums[i].value*(Math.abs(nums[j].index-nums[i].index));
				System.out.println("temp " + temp + "  " + j + " " + nums[j].index);
				if(temp > max) max = temp;
				
			}
			
		}
//		System.out.println(max);
		System.out.println("----------");
		for(int i = 0; i < nums.length; i++){
			System.out.println(nums[i].index + " " + nums[i].value);
		}
		return max;
	}
	
	class Num{
		int index;
		int value;
		public Num(){};
		public Num(int index, int value){
			this.index = index;
			this.value = value;
		}
	}

}
