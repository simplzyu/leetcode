package com.gzy.leetcode;

public class LeetCode260 {

	public static void main(String[] args) {
		int nums[] = {1,0};
		LeetCodeUtil.printIntegerArray(nums);
		LeetCodeUtil.printIntegerArray(new LeetCode260().singleNumber(nums));
	}

	public int[] singleNumber(int[] nums) {
		int recorder[] = new int[2];
		int t = 0,i=0;
		this.quickSort(nums, 0, nums.length-1);
		System.out.println("llll");
		LeetCodeUtil.printIntegerArray(nums);
		while(i < nums.length){
			if(i+1 == nums.length){
				recorder[t] = nums[i];
				break;
			}
			if(nums[i] == nums[i+1]){
				i = i+2;
			}else{
				recorder[t] = nums[i];
				if(t==1) break;
				t++;
				i += 1;
			}
		}
		return recorder;
	}
	
	public void quickSort(int[] a, int low, int high){
		if(low < high){
			int pivotloc = this.partition(a, low, high);//ºÜÖØÒª
			this.quickSort(a, low, pivotloc-1);
			this.quickSort(a, pivotloc+1, high);
		}
	}
	
	public int partition(int[] a, int low, int high){
		int pivotkey = a[low];
		while(low < high){
			while(low < high && a[high] >= pivotkey) high--;
			a[low] = a[high];
			while(low < high && a[low] <= pivotkey) low++;
			a[high] = a[low];
		}
		a[low] = pivotkey;
		return low;
	}
}
