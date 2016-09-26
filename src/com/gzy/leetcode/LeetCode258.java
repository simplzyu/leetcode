package com.gzy.leetcode;
/**Given a non-negative integer num, 
repeatedly add all its digits until the result has /only one digit/.
*/
public class LeetCode258 {
	public static void main(String[] args) {
		LeetCode258 lc = new LeetCode258();
		int temp = lc.addDigits(269);
		System.out.println(temp);
	}
	public int addDigits(int num) {
		int temp = num;
		while(Integer.toString(temp).length()!=1){
			temp = add(temp);
		}
		return temp;			
	}
	
	public int add(int num){
		String s = Integer.toString(num);
		int sum = 0;
		int len = s.length();
		for(int i = 0; i < len; i++){
//			System.out.println(num%10);
			sum = sum + num%10;
			num /= 10;
		}
		return sum;
	}
	
}
