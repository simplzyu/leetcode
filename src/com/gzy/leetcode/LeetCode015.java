/**
 * 
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * 
 */
package com.gzy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode015 {

	public static void main(String[] args) {
		LeetCode015 lc = new LeetCode015();
		// int[] nums = {-1,0,1,2,-1,-4};//-4 -1 -1 0 1 2;
//		int[] nums = {-1,0,1,2,-1,-4};// -2,-2,-1,-1,0,1,1,2,2
//		int[] nums = {};
//		int[] nums = {0,0,0};
//		int[] nums = {-1,0,1,0};//-1,0,0,1
		int[] nums = {0,2,2,3,0,1,2,3,-1,-4,2};//-4 -1 0 0 1 2 2 2 2 3 3 
		// lc.print(nums);
		// System.out.println();
		// lc.sort(nums);
		// lc.print(nums);
		List<List<Integer>> list = lc.threeSum(nums);
		// System.out.println(list.size());
		lc.printList(list);
	}

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (nums.length == 0) {
			// System.out.println("enter");
			return list;
		}
		// sort(nums);
		this.QuickSort(nums, 0, nums.length-1);
		this.print(nums);
		System.out.println();
		int i = 0;
		int j = 0;// nums.length-1;
		int t = 0;// nums.length/2-1;
		int low = 0, high = 0;
		int num1=-1,num2=-1,num3=-1;
		for (i = 0; i < nums.length - 2; i++) {
			if ((i > 0) && (nums[i] == nums[i - 1]))
				continue;
			low = i + 1;
			high = nums.length - 1;
			int temp = low;
			int dif = -(nums[i]);
			while (low < high) {
				if (nums[low] + nums[high] == dif) {
	//				 System.out.println(nums[low] + " " + low + " " + hight);
//					if ((nums[low] != nums[low + 1])|| (nums[low] == nums[high] && low+1 == high)) {
//						List<Integer> li = new ArrayList<Integer>();
//						li.add(nums[i]);
//						li.add(nums[low]);
//						li.add(nums[high]);
//						list.add(li);
//						high--;
//					}
					if(nums[i]!=num1 || nums[low]!=num2 || nums[high]!=num3){
						List<Integer> li = new ArrayList<Integer>();
						li.add(nums[i]);
						li.add(nums[low]);
						li.add(nums[high]);
						num1 = nums[i];
						num2 = nums[low];
						num3 = nums[high];
						list.add(li);
						high--;     //
					}				//
					low++;			//high--与low++一起的寻找下一组-4 1 3 过后，low与high必需动，否则如果low不变,high的值绝对相同
				} else if (nums[low] + nums[high] > dif) {
					high--;
				} else {
					low++;
				}
			}
		}
		return list;
	}

	public void sort(int[] nums) {
		int temp = 0;
		boolean flag = true;
		for (int i = 0; i < nums.length && flag; i++) {
			flag = false;
			for (int j = nums.length - 1; j > i; j--) {
				if (nums[j] < nums[j - 1]) {
					temp = nums[j - 1];
					nums[j - 1] = nums[j];
					nums[j] = temp;
					flag = true;
				}
			}
		}
	}
	
	public void QuickSort(int[] nums, int low, int hight){
		if(low < hight){
			int pivotloc = Partition(nums,low,hight);
			QuickSort(nums,low,pivotloc-1);
			QuickSort(nums,pivotloc + 1, hight);
		}
	}
	
	public int Partition(int[] nums, int low, int hight){
		int pivotkey = nums[low];
		while(low < hight){
			while(low<hight && nums[hight] >= pivotkey) hight--;
			nums[low] = nums[hight];
			while(low<hight && nums[low] <= pivotkey) low++;
			nums[hight] = nums[low];
		}
		nums[low] = pivotkey;
		return low;
	}

	public void print(int[] nums) {
		for (int i = 0; i < nums.length; i++)
			System.out.print(nums[i] + " ");
	}

	public void printList(List<List<Integer>> list) {
		for (int i = 0; i < list.size(); i++) {
			List<Integer> li = new ArrayList<Integer>();
			li = list.get(i);
			for (int j = 0; j < li.size(); j++) {
				System.out.print(li.get(j) + " ");
			}
			System.out.println();
		}
	}
}
