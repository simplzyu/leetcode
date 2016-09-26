package com.gzy.leetcode;

import java.util.Arrays;

public class LeetCode005 {
	public static void main(String[] args) {
		String s = "";
		LeetCode005 lc5 = new LeetCode005();
		String sub = lc5.longestPalindrome(s);
		System.out.println(sub);

	}
	//�����������������ڵ���ĸ����ͬ��С���У�Ȼ������������չ������"cabbae" bbΪ��ԭʼ�������У��Ƚ�s[1]��s[4]��s[0],��s[5]...
	//����������ĸΪ�����У�����"ceabaed",�Ƚ�s[2]��s[4],s[1]��s[5]...
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
	//�ж϶Գ�λ�Ƿ����
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
