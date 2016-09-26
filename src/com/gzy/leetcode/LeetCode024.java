package com.gzy.leetcode;

public class LeetCode024 {

	public static void main(String[] args) {
		LeetCode021 lc21 = new LeetCode021();
		ListNode head = new ListNode(1);
		lc21.creatList(head, 2, 3);//带头结点的链表，头结点为head
		LeetCode024 lc = new LeetCode024();
		head = lc.swapPairs(head.next);
		while(head!=null){
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
	
	public ListNode swapPairs(ListNode head) {
		if(head==null || head.next == null)
			return head;
		ListNode p = head;
		ListNode h = new ListNode(0);
		h.next = head.next;
		ListNode htemp = h;
		ListNode tail = head.next;
		while(p!=null){
			ListNode temp = p.next.next;
			htemp.next = p.next;
			tail.next = p;
			p.next = temp;
			if(temp == null || temp.next == null)
				break;
			htemp = p;
			p = p.next;
			tail = temp.next;
		}
		return h.next;
	}
}
