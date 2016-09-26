package com.gzy.leetcode;

public class LeetCode344 {
	public static void main(String[] args) {
		LeetCode344 lc = new LeetCode344();
		System.out.println(lc.reverseString("abcdefghijklmnopqrstuvwxyz"));
		System.out.println(lc.revers("abcdefghijklmnopqrstuvwxyz"));
	}

	public String reverseString(String s) {
		char[] ch = s.toCharArray();
		for (int i = 0; i < ch.length / 2; i++) {
			if (ch[i] != ch[ch.length - 1 - i]) {
				char c = ch[i];
				ch[i] = ch[ch.length - 1 - i];
				ch[ch.length - 1 - i] = c;
			}
		}
		return new String(ch);
	}
	
	public String revers(String s){
		char[] c = s.toCharArray();
		char[] c1 = new char[s.length()];
		for(int i = 0; i < c.length; i++){
			c1[c.length-1-i] = c[i];
		}
		return new String(c1);
	}
}
