package com.gzy.leetcode;

public class LeetCode009 {
	public static void main(String[] args) {
		System.out.println(LeetCode009.isPalindrome(1));
	}

	public static boolean isPalindrome(int x) {
		String s = String.valueOf(x);
		char[] ch = s.toCharArray();
		if(ch.length == 1) return true;
		int i = 0,j = ch.length-1;
		for(i = 0; i < ch.length/2; i++)
			if(ch[i] != ch[j--]) break;
		if(i == ch.length/2) return true;
		else return false;
	}
}
