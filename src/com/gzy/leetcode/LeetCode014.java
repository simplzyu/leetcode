/**
 * Longest Common Prefix
 */
package com.gzy.leetcode;

public class LeetCode014 {
	public static void main(String[] args) {
		String[] strs = {};
		LeetCode014 lc = new LeetCode014();
		System.out.println(lc.longestCommonPrefix(strs));
	}
	
	public int getMin(String[] strs){
		int min = strs[0].length();
		for(int i = 1; i < strs.length; i++){
			if(strs[i].length() < min){
				min = strs[i].length();
			}
		}
		return min;
	}

	public String longestCommonPrefix(String[] strs) {
		System.out.println(strs);
		if(strs.length == 0) return "";
		char[][] ch = new char[strs.length][];
		for(int i = 0; i < strs.length; i++){
			ch[i] = strs[i].toCharArray();
		}
		int i = 0;
		int j = 0;
		outer:for(j = 0; j <this.getMin(strs); j++){
			for( i = 0; i < strs.length-1; i++){
				if(ch[i][j] != ch[i+1][j]){
					System.out.println("enter" + j);
					break outer;
				}
			}
		}
		return new String(ch[0],0,j);
	}
}
