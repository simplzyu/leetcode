package com.gzy.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode022 {

	public static void main(String[] args) {
		LeetCode022 lc = new LeetCode022();
		List<String> list = lc.generateParenthesis(5);
		for(int i = 0; i < list.size(); i++){
			System.out.println(i + "\t" + list.get(i) + " ");
		}
	}

	public List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<String>();
		this.generate(list, n, n, "");
		return list;
	}
	
	public void generate(List<String> list, int l, int r, String s){
		if(l==0 && r==0){
			list.add(s);
			return ;
		}
		if(l > 0){
			generate(list, l-1, r, s+"(");
		}
		if(r > 0 && r > l){//ºÜÖØÒª
			generate(list, l, r-1, s+")");
		}
	}
}
