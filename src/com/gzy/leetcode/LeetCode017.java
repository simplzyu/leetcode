package com.gzy.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode017 {

	public static void main(String[] args) {
		LeetCode017 lc = new LeetCode017();
		lc.letterCombinations("23456789");
	}

	public List<String> letterCombinations(String digits) {
		String[] nums = digits.split("");
		List<String> list = new ArrayList<String>();
		if(digits.length() == 0) return list;
		String[][] base = { {"","",""},{"","",""},{ "a", "b", "c" }, { "d", "e", "f" }, { "g", "h", "i" }, { "j", "k", "l" },
				{ "m", "n", "o" }, { "p", "q", "r","s"}, { "t", "u", "v" }, { "w", "x", "y", "z" } };
		 list.add("");
		List<String> l = new ArrayList<String>();
		for(int i = 0; i < nums.length; i++){
			l.clear();
			//加入一个数字对应的字母
			int size = list.size();
			for(int j = 0; j < size; j++){
				this.add(l, list.get(j), base[Integer.parseInt(nums[i])]);
			}
			list.clear();
			list.addAll(l);
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + 1 + " " +list.get(i));
		}
		return list;
	}

	// 一个字符串加上一个字母
	public List<String> add(List<String> list, String s, String[] ch) {
		String[] ss = new String[ch.length];
		for (int i = 0; i < ch.length; i++) {
			ss[i] = s;
			ss[i] += ch[i];
			list.add(ss[i]);
		}
		return list;
	}
}
