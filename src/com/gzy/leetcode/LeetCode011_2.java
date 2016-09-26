package com.gzy.leetcode;

import com.gzy.leetcode.LeetCode011.Num;

public class LeetCode011_2 {
	
	public static void main(String[] args) {
		LeetCode011_2 lc = new LeetCode011_2();
		int[] height = {1,3,1,1};
		System.out.println(lc.maxArea(height));
	}
	
	public  int maxArea(int[] height) {
		 int low = 0,high = height.length-1;
		 int sa = 0;
		 while(low < high){
			 sa = Math.max(sa, Math.min(height[low], height[high])*(high-low));
			 if(height[low] < height[high]){
				 low++;
			 }else{            //如果两边同高，不管移那边都是减小，但是此时最大面积已经记录
				 high--;
			 }
		 }
		 return sa;
	}
}
