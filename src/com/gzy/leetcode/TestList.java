package com.gzy.leetcode;

import java.util.ArrayList;
import java.util.List;

public class TestList {
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(0,0); 
		list.add(1,3);
		System.out.println(list.get(0)+" " +list.get(1));
		list.add(0,3);//直接add(3)插最后，add(0,3)插首位
		for(int i = 0; i < list.size();i++){
			System.out.print(list.get(i)+ " ");
		}
		list.set(0, 7);//set方法可以改变ArrayList的值
		System.out.println("\n-----");
		for(int i = 0; i < list.size();i++){
			System.out.print(list.get(i)+ " ");
		}
	}
}
