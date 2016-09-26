package com.gzy.leetcode;

public class LeetCode004 {
	public static void main(String[] args) {
		int[] nums1 = {};
		int[] nums2 = {2, 3};
		long startTime = System.currentTimeMillis();
		double mid = new LeetCode004().findMedianSortedArrays(nums1, nums2);
		long stopTime = System.currentTimeMillis();
		System.out.println(mid);
		System.out.println(stopTime - startTime);
	}
	
	//Submit Ê±Ó¦°ÑSystem.out.print()×¢ÊÍµô***
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int i = 0, j = 0;
		int midNum = (nums1.length + nums2.length) / 2;
		int[] midArray = new int[midNum+1];
		int t;
//		System.out.println("mid:" + midNum);
		for (t = 0; t <= midNum && i < nums1.length && j < nums2.length; t++) {
			if (nums1[i] < nums2[j]) {
				midArray[t] = nums1[i];
//				System.out.println("1out " + midArray[t]);
				i++;
			} else {
				midArray[t] = nums2[j];
//				System.out.println("2out " + midArray[t]);
				j++;
			}
		}
		if (i == nums1.length) {
			int p = j;
			for (int f = t; f <= midNum; f++) {
				midArray[f] = nums2[p++];
			}
		}
		if (j == nums2.length) {
			for (int f = t; f <= midNum; f++) {
				midArray[f] = nums1[i++];
			}
		}
		if((nums1.length + nums2.length)%2==1)
			return midArray[midNum];
		else{
			return ((double)midArray[midNum-1] + (double)midArray[midNum])/2;
			}
	}
}
