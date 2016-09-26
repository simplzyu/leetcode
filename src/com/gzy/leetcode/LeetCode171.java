package com.gzy.leetcode;

public class LeetCode171 {
	
	public static void main(String[] args) {
		String s = "ABC";
		LeetCode171 lc = new LeetCode171();
		System.out.println(lc.title2Number(s));
	}
	
	public int titleToNumber(String s) {
        char[] chars = s.toCharArray();
        int num = 0;
        for(int i = 0; i < chars.length; i++){
        	num += (chars[i]-'A'+1)*(Math.pow(26, chars.length-i-1));
        }
        return num;
    }
	
	public int title2Number(String s){
		return this.getNumber(s.toCharArray(), 0, s.length()-1);
	}
	
	public int getNumber(char[]	c, int a, int b){
		if(a == b) return c[a]-'A'+1;
		return 26*getNumber(c,a,b-1)+(c[b]-'A'+1);
	}
}