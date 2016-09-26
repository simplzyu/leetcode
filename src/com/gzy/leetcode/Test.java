package com.gzy.leetcode;

public class Test {
	public static void main(String[] args) {
		int[] a = {3,6,7,6,2,1,5,8};
		Test test = new Test();
		test.quickSort(a, 0, a.length-1);
		test.print(a);
	}
	
	public void print(int a[]){
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i] + " ");
		}		
		System.out.println();
	}
	
	public void quickSort(int[] a, int low, int high){
		int pivotloc = this.partition(a, low, high);
//		System.out.println(pivotloc);
		if(low < high){
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
