package com.gzy.leetcode;

import java.util.Stack;

public class LeetCode020 {
	
	public static void main(String[] args) {
		String s = "()";
		LeetCode020 lc = new LeetCode020();
		System.out.println(lc.isValid(s));	
	}

	public boolean isValid(String s) {
		char[] ch = s.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		int i = 0;
		for(i = 0; i < ch.length; i++){
			if(ch[i] == '(' || ch[i]== '[' || ch[i] == '{'){
				stack.push(ch[i]);
			}else if(ch[i] == ')' || ch[i] ==']' || ch[i] == '}'){
				if(stack.size() == 0)
					break;
				char c = stack.get(stack.size()-1);
				c = this.change(c);
				if(c == ch[i])
					stack.pop();
				else
					break;
			}
		}
		if(stack.size() == 0 && i==ch.length)
			return true;
		else
			return false;
	}
	
	public char change(char c){
		if(c == '(')
			c = ')';
		else if(c=='[')
			c = ']';
		else if(c=='{')
			c = '}';
		return c;
	}
}
