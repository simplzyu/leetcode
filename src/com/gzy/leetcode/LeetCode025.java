package com.gzy.leetcode;

public class LeetCode025 {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7,8,9,10};
		ListNode list = LeetCodeUtil.createList(nums);
//		ListNode head = new ListNode(0);
//		head.next = list;
		LeetCode025 lc = new LeetCode025();
//		System.out.println(lc.getLength(list));
//		list = lc.reverseKGroup(head, 2);
		list = lc.reverseKGroup(list, 6);
		while(list!=null){
			System.out.print(list.val + " ");
			list = list.next;
		}
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode h = new ListNode(0);
		h.next = head;
		ListNode htemp = h;
		int len = this.getLength(h);
		for(int i = 0; i < len/k; i++){
			h = this.reverse_K(h, k);	
		}
		return htemp.next;
	}
	
	public ListNode reverse_K(ListNode head, int k) {
	//	if(head == null) return null;
	//	int len = this.getLength(head);
	//	if(len < k)
	//		return head;
		ListNode h = head;
		h.next = head.next;
		ListNode tail = head.next;
		ListNode p = head.next.next;
		for(int i = 1; i < k; i++){
			ListNode temp = p.next;
			p.next = h.next;
			h.next = p;
			p = temp;
		}
		tail.next = p;
		return tail;
	}
	
	//带头结点的链表的长度
	public int getLength(ListNode head){
		ListNode list = head.next;
		int t = 0;
		while(list!=null){
			t++;
			list = list.next;
		}
		return t;
	}
}
