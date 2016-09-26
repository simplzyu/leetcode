package com.gzy.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Definition for a binary tree node. 
 * public class TreeNode {
 * 	   int val; 
 *     TreeNode left; 
 *     TreeNode right; 
 *     TreeNode(int x) { val = x; } 
 *     }
 */

public class LeetCode145 {
	public static void main(String[] args) {
		LeetCode145 lc = new LeetCode145();
		TreeNode root = null;
		root = lc.createTree(root);
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> listTest = lc.postOrder(root,list);
/*		list = lc.add(list);
		list.add(1);
		list.add(2);
		list.add(3);*/
		lc.printList(listTest);
	}
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = null;
		return list;
	}
	
	public List<Integer> postOrder(TreeNode root,List<Integer> list){
//		System.out.println(root);
		if(root != null){
			postOrder(root.left,list);
			postOrder(root.right,list);
//			System.out.println(root.val);
			list.add(root.val);			
		}
		return list;
	}
	
	public void postOrderPrint(TreeNode root){
//		System.out.println(root);
		if(root != null){
			postOrderPrint(root.left);
			postOrderPrint(root.right);
			System.out.println(root.val);
		}
	}
	
	public void inOrderPrint(TreeNode root){
//		System.out.println(root);
		if(root != null){
			inOrderPrint(root.left);
			System.out.println(root.val);
			inOrderPrint(root.right);
		}
	}
	
	public TreeNode createTree(TreeNode root){
		Scanner scan = new Scanner(System.in);
		int val = scan.nextInt();
		if(val == -1)
			root = null;
		else{
			root = new TreeNode(val);
			root.left = createTree(root.left);
			root.right = createTree(root.right);
		}
		return root;
	}
	
	public List<Integer> add(List<Integer> list){
		Scanner scan = new Scanner(System.in);
		for(int i = 0; i < 5; i++){
			int val = scan.nextInt();
			list.add(val);
		}
		return list;
	}
	public void printList(List<Integer> list){
		for(int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));
	}
}

class TreeNode{
	int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
    	this.val = val;
    }
}
