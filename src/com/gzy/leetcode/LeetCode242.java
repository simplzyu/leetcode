package com.gzy.leetcode;

import java.util.Arrays;

public class LeetCode242 {
	public static void main(String[] args) {
		String s = "";
		String t = "";
		LeetCode242 lc = new LeetCode242();
		System.out.println(lc.isAnagram(s, t));
	}
	
	public boolean isAnagram(String s, String t) {
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        int i = 0;
        for(i = 0; i < c1.length && i < c2.length; i++){
        	if(c1[i] != c2[i]) break;
        }
        if(i == c1.length && i==c2.length) return true;
        else return false;
    }
}
