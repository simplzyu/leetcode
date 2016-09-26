package com.gzy.leetcode;

import java.util.Arrays;

public class LeetCode005 {
	public static void main(String[] args) {
		String s = "";
		LeetCode005 lc5 = new LeetCode005();
		String sub = lc5.longestPalindrome(s);
		System.out.println(sub);

	}
	//先找序列中两个紧邻的字母是相同的小序列，然后再向两边扩展，例："cabbae" bb为最原始的子序列，比较s[1]与s[4]，s[0],与s[5]...
	//再找三个字母为子序列，例："ceabaed",比较s[2]与s[4],s[1]与s[5]...
	public String longestPalindrome(String s) {
		if(s.length() == 0) return "";
		char[] c = s.toCharArray();
		int low, high, max = 0;
		int left = -1, right = 1;
		for (int i = 0; i < c.length - 1; i++) {
			low = i;
			high = i + 1;
			while (isPalindrome(c, low, high)) {
				low--;
				high++;
			}
			if(max < (high - low -1)){
				max = (high - low - 1);
				left = low;
				right = high;
			}
			low = i - 1;
			high = i + 1;
			while(isPalindrome(c, low, high)){
				low --;
				high ++;
			}
			if(max < (high - low -1)){
				max = (high - low - 1);
				left = low;
				right = high;
			}
		}
		char[] cop = Arrays.copyOfRange(c, left+1, right);
		String subString = String.valueOf(cop);
		return subString;
	}
	//判断对称位是否相等
	public boolean isPalindrome(char[] c, int low, int high) {
		if ((low == -1) || (high == c.length))
			return false;
		else {
			if (c[low] == c[high])
				return true;
			else
				return false;
		}
	}
}
