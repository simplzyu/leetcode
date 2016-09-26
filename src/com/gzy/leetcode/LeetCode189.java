package com.gzy.leetcode;

public class LeetCode189 {
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7};
		LeetCode189 lc = new LeetCode189();
		lc.rotate2(a, 5);
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i] + " ");
		}
	}
	
	public void rotate(int[] nums, int k) {
		k = k%nums.length;
        this.rotateArray(nums, 0, nums.length-1-k);
        this.rotateArray(nums,nums.length-k, nums.length-1);
        this.rotateArray(nums, 0, nums.length-1);
    }
	
	public void rotateArray(int[] nums,int left, int right){
		int temp = 0;
		for(int i = left; i < (right+left +1 )/2; i++){//此处不能用i <=(right+left)/2
			temp = nums[i];
			nums[i] = nums[right+left-i];
			nums[right+left-i] = temp;
		}
	}
	
	public void rotate2(int[] nums, int k){
		k = k%nums.length;
//		if(k == 0) return ;
		int[] temp = new int[k];
		for(int i = nums.length-k, t = 0; i < nums.length; i++){
			temp[t++] = nums[i];
		}
		
		for(int i = nums.length-1,t = nums.length-k-1; i >= k; i--){
			nums[i] = nums[t--];
		}
		for(int i = 0; i < k; i++){
			nums[i] = temp[i];
		}
	}
}

