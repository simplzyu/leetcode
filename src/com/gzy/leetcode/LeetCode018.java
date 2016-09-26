package com.gzy.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode018 {
	public static void main(String[] args) {
		int[] nums = { 1, 0, -1, 0, -2, 2 };
		LeetCode018 lc = new LeetCode018();
		List<List<Integer>> res = lc.fourSum(nums, 0);
		for (int i = 0; i < res.size(); i++) {
			List<Integer> list = res.get(i);
			for (int j = 0; j < list.size(); j++) {
				System.out.print(list.get(j) + " ");
			}
			System.out.println();
		}
	}

	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums.length == 0)
			return res;
		this.quickSort(nums, 0, nums.length - 1);
		int low = 1, high = nums.length - 1;
		int mark = nums[0] + 1;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] != mark) {
				int dif = target - nums[i];
				List<List<Integer>> list = this.threeSum(nums, i + 1, nums.length - 1, dif);
				for (int t = 0; t < list.size(); t++) {
					List<Integer> temp = list.get(t);
					temp.add(0, nums[i]);
					res.add(temp);
				}
			}
			mark = nums[i];
		}
		return res;
	}

	public List<List<Integer>> threeSum(int[] nums, int left, int right, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums.length < 3)
			return res;
		// this.quickSort(nums, 0, nums.length - 1);
		int low = left, high = right;
		int mark = nums[left] + 1; // +1只是为了让mark != nums[0];
		int n1 = nums[left], n2 = nums[left], n3 = target - nums[left] - nums[left] + 1; // 此处加1是为了让三者的和与target不相等
		for (int i = left; i < nums.length - 2; i++) {
			if (nums[i] != mark) {
				low = i + 1;
				high = nums.length - 1;
				int dif = target - nums[i];
				while (low < high) {
					if (dif == nums[low] + nums[high]) {
						if (n1 != nums[i] || n2 != nums[low] || n3 != nums[high]) {
							List<Integer> list = new ArrayList<Integer>();
							list.add(nums[i]);
							list.add(nums[low]);
							list.add(nums[high]);
							n1 = nums[i];
							n2 = nums[low];
							n3 = nums[high];
							res.add(list);
						}
						low++;
						high--;
					} else if (dif > nums[low] + nums[high]) {
						low++;
					} else {
						high--;
					}
				}
			}
			mark = nums[i];
		}
		return res;
	}

	public void quickSort(int a[], int low, int high) {
		if (low < high) {
			int pivotloc = this.partition(a, low, high);
			quickSort(a, low, pivotloc - 1);
			quickSort(a, pivotloc + 1, high);
		}
	}

	public int partition(int a[], int low, int high) {
		int pivotkey = a[low];
		while (low < high) {
			while (low < high && a[high] >= pivotkey)
				high--;
			a[low] = a[high];
			while (low < high && a[low] <= pivotkey)
				low++;
			a[high] = a[low];
		}
		a[low] = pivotkey;
		return low;
	}

}
