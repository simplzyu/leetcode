package com.gzy.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LeetCode169 {
	public static void main(String[] args) {
//		int[] nums = {1,2,3,2,9,2,5,2,2};
//		LeetCode169 lc = new LeetCode169();
//		lc.quickSort(nums, 0, nums.length-1);
//		for(int i = 0; i < nums.length; i++){
//			System.out.print(nums[i] + " ");
//		}
//		System.out.println("\n" + lc.majorityElement(nums));
		int[] nums = {1,2,3,2,4,2};
		LeetCode169 lc = new LeetCode169();
		System.out.println(lc.majorityElement2(nums));
	}
	
	public int majorityElement(int[] nums) {
        this.quickSort(nums, 0, nums.length-1);//此外使用Arrays.sort(nums)更快 
        return nums[nums.length/2];
    }
	
	//快排
	public void quickSort(int[] nums, int low, int high){
		if(low < high && !this.isOrder(nums,low,high)){
			int pivotloc = this.partition(nums, low, high);
			this.quickSort(nums, low, pivotloc-1);
			this.quickSort(nums, pivotloc+1, high);
		}
	}
	
	//找枢纽值
	public int partition(int[] nums, int low, int high){
//		this.swap(nums,0,(low+high)/2);
		int pivotkey = nums[low];
		while(low < high){
			while(low < high && nums[high] >= pivotkey) high--; 
			nums[low] = nums[high];
			while(low < high && nums[low] <= pivotkey) low++;
			nums[high] = nums[low];
		}
		nums[low] = pivotkey;
		return low;
	}
	
//	public void swap(int[] nums, int a, int b){
//		int t = nums[a];
//		nums[a] = nums[b];
//		nums[b] = t;
//	}
	
	public boolean isOrder(int[] nums, int low, int high){
		if(high - low < 1) return true;
		for(int i = low+1; i <= high; i++){
			if(nums[i] < nums[i-1]){
				return false;
			}
		}
		return true;
	}
	
	public int majorityElement2(int[] nums) {
        int res=nums[0];
        int count = 1;
        for(int n: nums){
        	if(res == n) count ++;
        	else count --;
        	if(count <= 0){
        		res = n;
        		count = 1;
        	}
        }
        return res;
    } 
}
