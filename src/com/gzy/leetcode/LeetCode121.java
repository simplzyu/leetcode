package com.gzy.leetcode;

public class LeetCode121 {
	public static void main(String[] args) {
		int[] prices = {7, 1, 5, 3, 6, 4, 7};
		LeetCode121 lc = new LeetCode121();
		int max = lc.maxProfit(prices);
		System.out.println(max);
	}
	
	public int maxProfit(int[] prices) {
//		int left = 0, right = 1;
		int max = 0;
		for(int i = 0; i < prices.length; i++){
			for(int j = i+1; j < prices.length; j++){
				if(prices[i] >= prices[j]){
					break;
				}else{
					int temp = prices[j] - prices[i];
					if(temp > max) max = temp;
				}
			}			
		}
        return max;
    }
}