package com.gzy.leetcode;

public class LeetCode058 {
	public static void main(String[] args) {
		LeetCode058 lc = new LeetCode058();
		String s = "hello world";
		int len = lc.lengthOfLastWord(s);
		System.out.println(len);
	}
	
	public int lengthOfLastWord(String s) {
        String[] ss = s.split(" ");
        if(ss.length == 0) return 0;
        return ss[ss.length-1].length();
    }
}
