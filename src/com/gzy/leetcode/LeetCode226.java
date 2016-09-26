package com.gzy.leetcode;
/**
 * 将二叉树对称翻转
 * */
public class LeetCode226 {
	public static void main(String[] args) {
		TreeNode root = null;
		root = new LeetCode145().createTree(root);
/*		LeetCode145 lc = new LeetCode145();
		lc.inOrderPrint(root);
		LeetCode226 lc2 = new LeetCode226();
		lc2.levelRevert(root);
		lc.inOrderPrint(root);*/
		new LeetCode226().invertTree(root);
	}

	public TreeNode invertTree(TreeNode root) {
		return levelRevert(root);
	}

	public TreeNode levelRevert(TreeNode root) {
		TreeNode temp, p = root;
		TreeNode[] Q = new TreeNode[65536];
		int front = -1, rear = -1;
		int last = 0, level = 0;
		if (p == null)
			return null;
		else {
			Q[++rear] = p;
			while (rear > front) {
				p = Q[++front];
				temp = p.left;
				if (p.left != null) {
					Q[++rear] = p.left;
				}
				p.left = p.right;
				if (p.right != null) {
					Q[++rear] = p.right;
				}
				p.right = temp;
				if (last == front) {
					last = rear;
					level++;
				}
			}
		}
		// print(Q,rear+1);
		// System.out.println("rear" + rear);
		return root;
	}
	
	//先序和后序是可以的，中序不行
	public TreeNode preOrderInvert(TreeNode root){
		if(root == null)
			return null;
		else{
			TreeNode temp = root.left;
			root.left = root.right;
			root.right = temp;
			preOrderInvert(root.left);
			preOrderInvert(root.right);	
			return root;
		}
	}

	public void print(TreeNode[] root, int len) {
		for (int i = 0; i < len; i++) {
			System.out.print(" " + root[i].val);
		}
	}
}
