package com.gzy.leetcode;

import java.util.ArrayList;
import java.util.List;

public class TestList {
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(0,0); 
		list.add(1,3);
		System.out.println(list.get(0)+" " +list.get(1));
		list.add(0,3);//ֱ��add(3)�����add(0,3)����λ
		for(int i = 0; i < list.size();i++){
			System.out.print(list.get(i)+ " ");
		}
		list.set(0, 7);//set�������Ըı�ArrayList��ֵ
		System.out.println("\n-----");
		for(int i = 0; i < list.size();i++){
			System.out.print(list.get(i)+ " ");
		}
	}
}
