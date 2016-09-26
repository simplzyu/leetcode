package com.gzy.leetcode;

public class LeetCode028 {
	public static void main(String[] args) {
		String str = "a";
		String needle = "a";
		System.out.println(new LeetCode028().strStr(str, needle));
	}

	public int strStr(String haystack, String needle) {
		if(haystack.length() == 0 && needle.length() == 0) return 0;
		int i = 0,t = 0,j = 0;
		for(i = 0; i <= haystack.length()-needle.length(); i++){
			t = i;
			for(j = 0; j < needle.length() && t < haystack.length(); j++){
				if(haystack.charAt(t++) != needle.charAt(j))
					break;
			}
			if(j == needle.length())
				return i;
		}
		return -1;
	}
	
	public boolean isContain(char[] haystack,int low1, char[] needle){
		int i = 0;
		int j = 0;
		for(i = low1, j = 0; j < needle.length && i < haystack.length; i++,j++){
			if(haystack[i] != needle[j])
				break;
		}
		if(j == needle.length)
			return true;
		else
			return false;
	}
}
