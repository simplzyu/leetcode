package com.gzy.leetcode;

/**
 * 求树的深度
 * */
public class LeetCode104 {
	public static void main(String[] args) {
		TreeNode root = null;
		root = new LeetCode145().createTree(root);
//		new LeetCode145().postOrderPrint(root);
//		new LeetCode145().inOrderPrint(root);
		LeetCode104 lc = new LeetCode104();
		System.out.println(lc.maxDepth(root));
		System.out.println(lc.maxHigh(root));		
	}
	
	public int maxDepth(TreeNode root) {
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
	
	public int maxHigh(TreeNode root){
		TreeNode p = root;
		TreeNode[] Q = new TreeNode[65536];
		int front = -1, rear = -1;
		int last = 0, level = 0;
		if(p == null) return 0;
		else{
			Q[++rear] = p;
			while(rear > front){
				p = Q[++front];
				if(p.left!=null) Q[++rear] = p.left;
				if(p.right!=null) Q[++rear] = p.right;
				if(last == front){
					last = rear;
					level++;
				}
			}
		}
		return level;
	}
}

