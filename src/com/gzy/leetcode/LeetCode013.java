/**
 * Given a roman numeral, convert it to an integer.
 * I=1,V=5,X=10,L=50,C=100,D=500,M=1000
 */
package com.gzy.leetcode;

public class LeetCode013 {
	public static void main(String[] args) {
		int sum = new LeetCode013().romanToInt("DCXXI");
		System.out.println(sum);
	}

	public int romanToInt(String s) {
		char[] ch = s.toCharArray();
		int sum = this.getDec(ch[s.length()-1]);
		int n1 = sum,n2 = 0;
		for(int i = s.length()-2; i >= 0; i--){
			n2 = n1;
			n1 = this.getDec(ch[i]);
			if(n2 <= n1){
				sum+=n1;
			}else{
				sum-=n1;
			}
		}
		return sum;
	}
	
	public int getDec(char c){
		switch(c){
		case 'I':return 1;
		case 'V':return 5;
		case 'X':return 10;
		case 'L':return 50;
		case 'C':return 100;
		case 'D':return 500;
		case 'M':return 1000;
		default:return 0;
		}	
	}
}
