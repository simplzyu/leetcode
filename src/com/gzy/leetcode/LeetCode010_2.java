package com.gzy.leetcode;

public class LeetCode010_2 {
	public static void main(String[] args) {
		LeetCode010_2 lc = new LeetCode010_2();
		String s = "acda";
		String p = "ac*a";
		System.out.println(lc.isMatch(s, p));
	}

	public boolean isMatch(String s, String p) {
		if(p.length() == 0)
			return s.length()==0;
		if(p.length() == 1){
			if(s.length() < 1)
				return false;
			if(s.charAt(0)!=p.charAt(0) && p.charAt(0)!='.')//&&非常重要（不是||）(s='a' p='.') a!='.'||'.'!='.'为true直接返回false;
				return false;
			return isMatch(s.substring(1), p.substring(1));
		}
		if(p.charAt(1)!='*'){
			if(s.length()<1)
				return false;
			if(s.charAt(0)!=p.charAt(0) && p.charAt(0)!='.')
				return false;
			return isMatch(s.substring(1), p.substring(1));			
		}else{
			if(isMatch(s, p.substring(2)))
					return true;
			int i = 0;
			while(i < s.length() && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')){
				if(isMatch(s.substring(i+1),p.substring(2)))
					return true;
				i++;
			}
			return false;
		}
	}
}
