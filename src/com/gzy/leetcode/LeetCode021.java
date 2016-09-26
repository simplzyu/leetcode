package com.gzy.leetcode;

public class LeetCode021 {
	public static void main(String[] args) {
		LeetCode021 lc = new LeetCode021();
		ListNode head1 = new ListNode(0);
		ListNode head2 = new ListNode(1);
		lc.creatList(head1, 1, 6);
		lc.creatList(head2, 3, 8);
//		while(head1!=null){
//			System.out.print(head1.val + " ");
//			head1 = head1.next;
//		}
//		System.out.println();
//		while(head2!=null){
//			System.out.print(head2.val + " ");
//			head2 = head2.next;
//		}
//		System.out.println("-----------");
		lc.mergeTwoLists(head1.next, head2.next);
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode p1 = l1;
		ListNode p2 = l2;
		ListNode head = new ListNode(0);
		ListNode tail = head;
		ListNode temp = null;
		while(p1!=null &&p2!=null){
			if(p1.val < p2.val){
				temp = p1.next;
				tail.next = p1;
				tail = p1;
				p1 = temp;
			}else{
				temp = p2.next;
				tail.next = p2;
				tail = p2;
				p2 = temp;
			}
		}
		while(p1!=null){
			tail.next = p1;
			tail = p1;
			p1 = p1.next;
		}
		while(p2!=null){
			tail.next = p2;
			tail = p2;
			p2 = p2.next;
		}
		tail.next = null;
		ListNode h = head;
		while(h!=null){
			System.out.println(h.val);
			h = h.next;
		}
		return head.next;
	}
	
	//带头结点，head为头结点
	public void creatList(ListNode head,int n1, int n2){
		ListNode p = head;
		ListNode tail = p;
		for(int i = n1; i <= n2; i++){
			ListNode ln = new ListNode(i);
			tail.next = ln;
			tail = ln;
		}
		tail.next = null;
	}
}