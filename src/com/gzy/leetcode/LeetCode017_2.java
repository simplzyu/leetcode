package com.gzy.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode017_2 {
	public static void main(String[] args) {
		LeetCode017_2 lc = new LeetCode017_2();
		List<String> list = lc.letterCombinations("23456789");
		
		for(int i = 0; i < list.size(); i++){
			System.out.println(i+1 + "-- " +list.get(i));
		}
	}
	
	public List<String> letterCombinations(String digits) {
		String[][] base = { {"","",""},{"","",""},{ "a", "b", "c" }, { "d", "e", "f" }, { "g", "h", "i" }, { "j", "k", "l" },
				{ "m", "n", "o" }, { "p", "q", "r","s"}, { "t", "u", "v" }, { "w", "x", "y", "z" } };
		String nums[] = digits.split("");
		List<String> list = new ArrayList<String>();
		List<String> l = new ArrayList<String>();
		if(digits.length()==0) return list;
		list.add("");
		for(int i = 0; i < nums.length; i++){
			l.clear();
			int size = list.size();
			for(int j = 0; j < size; j++){
				this.add(l, list.get(j), base[Integer.parseInt(nums[i])]);
			}
			list.clear();
			list.addAll(l);
		}
		return list;
	}
	
	public void add(List<String> list, String str, String[] nums){
		String[] ss = new String[nums.length];
		for(int i = 0; i < nums.length; i++){
			ss[i] = str;
			ss[i] += nums[i];
			list.add(ss[i]);
		}
	}
}
