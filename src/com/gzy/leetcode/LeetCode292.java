package com.gzy.leetcode;

public class LeetCode292 {
	
	public static void main(String[] args) {
		System.out.println(new LeetCode292().canWinNim(58));
	}
	
	public boolean canWinNim(int n) {
        if(n%4!=0)
            return true;
        else
            return false;
    }
}
