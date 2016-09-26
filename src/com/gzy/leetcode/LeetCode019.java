package com.gzy.leetcode;

public class LeetCode019 {
	public static void main(String[] args) {
		LeetCode086 lc86 = new LeetCode086();
		LeetCode019 lc19 = new LeetCode019();
		int[] array = {1,7,3,2,5,9,2};
		ListNode head = lc86.createList(array);
//		head = lc19.removeNthFromEnd(head, 1);
		head = lc19.removeNthFromEnd2(head, 7);
		lc86.printList(head);
//		System.out.println(lc19.listLen(head));
	}
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		int listLenth = listLen(head);
//		System.out.println(listLenth);
		ListNode temp = head;
		if(listLenth == n) return head.next;
		else{
//			System.out.println("len - n" + (listLenth - n));
			for(int i =0; i < listLenth - n -1; i++){
				temp = temp.next;
			}
//			System.out.println("del:" + temp.next.val );
			temp.next = temp.next.next;
			return head;
		}
	}
	
	public int listLen(ListNode head){
		int i = 0;
		while(head != null){
			i++;
			head = head.next;
		}
		return i;
	}
	
	public ListNode removeNthFromEnd2(ListNode head, int n) {
		ListNode head1 = head,head2 = head;
		ListNode headNode = head2;
		for(int i = 0; i < n; i++)
		{
			head1 = head1.next;
//			System.out.println(head1.val);
		}
		if(head1 == null) return head.next;
		head1 = head1.next;
		while(head1 != null && head2 != null){
			System.out.println("---" + head1.val);
			head1 = head1.next;
			head2 = head2.next;
		}
		head2.next = head2.next.next;
		return headNode;
	}
}
