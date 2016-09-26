package com.gzy.leetcode;

public class LeetCode029_2 {
	public static void main(String[] args) {
		LeetCode029_2 lc = new LeetCode029_2();
		int res = lc.divide(-2147483648,1);
		System.out.println(res);
	}

	public int divide(int dividend, int divisor) {
		if(divisor == 1){
			return dividend;
		}
		if(divisor == -1){
			if(dividend == -2147483648)
				return 2147483647;
			else
				return -dividend;
		}
		int flag = 0;
		if(dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0)
			flag = 1;
		long a = Math.abs((long)dividend);
		long b = Math.abs((long)divisor);
		int res = 0;
		while(a >= b){
			long c = b;
			for(int i = 0; a >= c; i++){
				a -= c;
				res += 1<<i;
				c=c<<1;
			}
		}
		if(flag == 1) return -res;
		return res;
	}
}
