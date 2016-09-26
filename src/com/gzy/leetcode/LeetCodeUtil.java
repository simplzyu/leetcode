package com.gzy.leetcode;

public class LeetCodeUtil {
	//先序创建二叉树
	public static ListNode createList(int[] array) {
		if(array.length == 0) return null;
		ListNode head = new ListNode(array[0]);
		ListNode temp = head;
		for (int i = 1; i < array.length; i++) {
			ListNode node = new ListNode(array[i]);
			temp.next = node;
			temp = node;
		}
		temp.next = null;
		return head;
	}
	public static int[] getArray(){
		int[] array = {1,7,3,2,5,9,2};
		return array;
	}
	//得到单链表的长度
	public static int getlistLen(ListNode head){
		int i = 0;
		while(head != null){
			i++;
			head = head.next;
		}
		return i;
	}
	//求二叉树的深度
	public static int maxDepth(TreeNode root) {
		if(root == null)
			return 0;
		else{
			int leftDepth = maxDepth(root.left);
//			System.out.println("left" + leftDepth);
			int rightDepth = maxDepth(root.right);
//			System.out.println("right" + rightDepth);
			return (leftDepth>rightDepth?leftDepth:rightDepth) +1;
		}
	}
	//输出char[]
	public static void printCharArray(char[] ch){
		System.out.println("Array: ");
		for(int i = 0; i < ch.length; i++){
			System.out.print(ch[i] + " ");
		}
	}
	//输出一维数组
	public static void printIntegerArray(int[] digits){
		System.out.print("Array: ");
		for(int i = 0; i < digits.length; i++)
			System.out.print(digits[i]+ " ");
		System.out.println();
	}
	//输出单链表
	public static void printList(ListNode head) {
//		System.out.println(head.val);
		System.out.print("list: ");
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
	
	//输出二维数组
	public static void printTwoDimensionArray(int[][] grid){
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[0].length; j++)
				System.out.print(grid[i][j]);
			System.out.println("");
		}
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int val) {
		this.val = val;
	}
}
