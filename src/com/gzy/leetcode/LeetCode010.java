package com.gzy.leetcode;

public class LeetCode010 {
	public static void main(String[] args) {
		String s = "aaa";
		String regex ="a*ab";
//		System.out.println(s.matches(regex));
		System.out.println(isMatch(s,regex));
	}

	public static boolean isMatch(String s, String p) {
		if (s.equals(p))
			return true;
		else {
			char[] schar = s.toCharArray();
			char[] pchar = p.toCharArray();
			if(pchar.length == 2 && pchar[0] == '.' && pchar[1] == '*') return true;
			int i, j = 0;
			for (i = 0; i < s.length() && j < p.length(); i++, j++) {
				if (schar[i] != pchar[j]) {
					if (pchar[j] == '.') {
				//		if()
						continue;
					} else if (pchar[j] == '*') {
						if (j-1 >= 0 && schar[i] == pchar[j - 1] ) {
							if((j+1)<pchar.length && schar[i] == pchar[j + 1]) continue;
							if(i!=schar.length-1) j--;
						} else if(j-1 >= 0 && pchar[j-1] == '.'){
							if(!((i+1 < schar.length) && ((j+1) < pchar.length) &&(schar[i+1]==pchar[j+1]))){
								if(i!=schar.length-1) j--;
							}
						} else if ((j+1)<pchar.length && schar[i] != pchar[j + 1]) {
							return false;
							//如果schar[i] == pchar[j + 1]则 j++ 如s="aab",p="c*a*b"
						} else{
							System.out.println(j);
							j++;
						}
					} else if ((j+1 < pchar.length) && pchar[j + 1] == '*') {
						i--;
						j++;
					}
				}
			}
	//		System.out.println(i + " " + j);
			if (i == s.length()&& j==p.length())
				return true;
			else
				return false;
		}
	}
}
