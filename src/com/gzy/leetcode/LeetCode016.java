package com.gzy.leetcode;

public class LeetCode016 {

	public static void main(String[] args) {
		int[] nums = {-1,2,1,-4};
		LeetCode016 lc = new LeetCode016();
		int sum = lc.threeSumClosest(nums, 2);
		System.out.println(sum);
	}

	public int threeSumClosest(int[] nums, int target) {
		this.quickSort(nums, 0, nums.length-1);
		int n = nums.length-1;
		int sum = nums[0] + nums[1] + nums[n];
		int dif_abs = Math.abs(sum - target);
		for(int i = 0; i < nums.length; i++){
			int low = i+1,high=nums.length-1;
			while(low < high){
				int temp_sum = nums[i] + nums[low] + nums[high];
				int temp_dif = target-temp_sum; 
				int temp_dif_abs = Math.abs(temp_dif);
				if(temp_dif_abs < dif_abs){
					dif_abs = temp_dif_abs;
					sum = temp_sum;
				}
				if(temp_dif > 0){
					low++;					
				}else if(temp_dif <0){
					high--;
				}else{
					return sum;
				}
					
			}
				
		}
		return sum;
	}
	
	public void quickSort(int a[], int low, int high){
		if(low < high){
			int pivotloc = this.partition(a, low, high);
			this.quickSort(a, low, pivotloc-1);
			this.quickSort(a, pivotloc+1, high);
		}
	}
	
	public int partition(int a[], int low, int high){
		int pivotkey = a[low];
		while(low < high){
			while(low < high && a[high] >= pivotkey) high--;
			a[low] = a[high];
			while(low < high & a[low] <= pivotkey) low++;
			a[high] = a[low];
		}
		a[low] = pivotkey;
		return low;
	}
}
