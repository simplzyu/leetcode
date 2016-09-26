package com.gzy.leetcode;

import java.util.Arrays;

/**
 * 求一个数列中两个数之和等于给定的目标数(target)相等的下标
 * */
public class LeetCode001 {
	public static void main(String[] args) {
		int[] array = { 0, 4, 3, 0 };
		long startTime = System.currentTimeMillis();
		// int[] array = {2, 7, 11, 15};

		LeetCode001 lc1 = new LeetCode001();
		int[] res = new int[2];
		res = lc1.twoSum2(array, 0);
		long stopTime = System.currentTimeMillis();
		System.out.println("time:" + (stopTime - startTime));
		LeetCodeUtil.printIntegerArray(res);
	}

	// 暴力法
	public int[] twoSum(int[] nums, int target) {
		int[] res = new int[2];
		int temp, i = 0, j = 0;
		outer: for (i = 0; i < nums.length; i++) {
			temp = target - nums[i];
			for (j = 0; j < nums.length; j++) {
				if (j == i)
					continue;
				if (nums[j] == temp)
					break outer;
			}
		}
		res[0] = i;
		res[1] = j;
		return res;
	}

	// 先排序再从两边向中间夹逼
	public int[] twoSum2(int[] nums, int target) {
		int[] res = new int[2];
		int t1, t2, temp, i = 0, j = nums.length - 1;
		int[] copNums = Arrays.copyOf(nums, nums.length);
		Arrays.sort(nums);
		while (j > i) {
			temp = nums[i] + nums[j];
			System.out.println("num[i]:" + nums[i] + "nums[j]" + nums[j] + "i:"
					+ i + "j:" + j + "temp:" + temp);
			if (temp == target)
				break;
			else if (temp > target)
				j--;
			else
				i++;
		}
		LeetCodeUtil.printIntegerArray(copNums);
		for (t1 = 0; t1 < copNums.length; t1++)
			if (copNums[t1] == nums[i]) {
				break;
			}
		for (t2 = 0; t2 < copNums.length; t2++) {
			if (copNums[t2] == nums[j]) {
				if (t1 != t2)
					break;
			}
		}
		res[0] = (t1 < t2 ? t1 : t2);
		res[1] = (t1 > t2 ? t1 : t2);
		return res;
	}
}
