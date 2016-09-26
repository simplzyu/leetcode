package com.gzy.leetcode;

import java.util.Stack;

public class TestStack {
	public static void main(String[] args) {
		Stack<Character> stack = new Stack<Character>();
		stack.push('1');
		stack.push('2');
		char c = stack.get(stack.size()-1);
		System.out.println(c);
		stack.pop();
		System.out.println("size " + stack.size());
	}
}
