package com.gzy.leetcode;

public class LeetCode029 {
	public static void main(String[] args) {
		LeetCode029 lc = new LeetCode029();
		int res = lc.divide(-2147483648,2);
		System.out.println(res);
	}

	public int divide(int dividend, int divisor) {
        int flag = 0;
		int t = 0;
		if(dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) flag = 1;
		if(divisor == 1) return dividend;
		if(divisor == -1){
			if(dividend == -2147483648)
				dividend = -2147483647;
			return -dividend;
		}
		divisor = Math.abs(divisor);
		dividend = Math.abs(dividend);		
		int num = dividend - divisor;
		while(num >= 0){
			num -= divisor; 
			t++;
		}
		if(flag == 1) t = -t;
		return t;
    }
}
