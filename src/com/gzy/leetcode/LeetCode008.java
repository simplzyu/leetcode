package com.gzy.leetcode;

import java.util.Arrays;

public class LeetCode008 {
	
	public static void main(String[] args) {
		LeetCode008 lc8 = new LeetCode008();
		System.out.println(lc8.myAtoi("b11228552307"));
	}
	
	public int myAtoi(String str) {
		int low,high,i,res = 0;
		str = str.trim();
		char[] ch = str.toCharArray();
		for(i = 0; i < ch.length ; i++){
			if(ch[i]>= '0' && ch[i] <= '9')
				break;
		}
		low = i;
		for(i = low; i < ch.length; i++){
			if(!(ch[i]>= '0' && ch[i] <= '9'))
				break;
		}
		high = i;
		if(low == high) return 0;
		if(low > 1) return 0;
		else if(low == 1){
			if(ch[0] == '+'){
				char[] c = Arrays.copyOfRange(ch, low, high);
				try{
					res = Integer.parseInt(String.valueOf(c));
				}catch(Exception e){
					return 2147483647;
				}
			}else if(ch[0] == '-'){
				char[] c = Arrays.copyOfRange(ch, 0, high);
				try{
					res = Integer.parseInt(String.valueOf(c));
				}catch(Exception e){
					return -2147483648;
				}			
			}else if(ch[0]>= '0' && ch[0] <= '9'){
				char[] c = Arrays.copyOfRange(ch, 0, high);
				try{
					res = Integer.parseInt(String.valueOf(c));
				}catch(Exception e){
					return 2147483647;
				}	
			}else{
				return 0;
			}
		}else{
			char[] c = Arrays.copyOfRange(ch, 0, high);
			try{
				res = Integer.parseInt(String.valueOf(c));
			}catch(Exception e){
				return 2147483647;
			}
		}
		return res;
	}
}
