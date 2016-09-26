package com.gzy.leetcode;
/**
 * 把两个链表当作数字相加（每个结点都相当于一个位）相加（从左到右）*/
public class LeetCode002 {
	public static void main(String[] args) {
		// int[] array = lcu.getArray();
		int[] array1 = { 7,0,3,6,7,3,2,1,5};
		int[] array2 = { 9,2,5,5,6,1,2,2,4};
		ListNode l1, l2, head;
		l1 = LeetCodeUtil.createList(array1);
		l2 = LeetCodeUtil.createList(array2);
		LeetCode002 lc2 = new LeetCode002();
		head = lc2.addTwoNumbers(l1, l2);
		LeetCodeUtil.printList(head);
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int val, udig = 0, ddig = 0;
		ListNode head = new ListNode(0);
		ListNode head2 = new ListNode(0);
		head.next = l1;
		head2.next = l2;
		// System.out.println(head.next.val);
		while (head.next != null && head2.next != null) {
			val = head.next.val + head2.next.val + ddig;
			System.out.println(val);
			udig = val % 10;
			ddig = val / 10;
			head.next.val = udig;
			head2.next.val = udig;
			head = head.next;
			head2 = head2.next;
		}
		if (head.next != null) {
			while (head.next != null) {
				val = head.next.val + ddig;
				udig = val % 10;
				ddig = val / 10;
				head.next.val = udig;
				head = head.next;
			}
			if (ddig != 0) {
				ListNode node = new ListNode(ddig);
				head.next = node;
			}
			return l1;
		} else {
			while (head2.next != null) {
				val = head2.next.val + ddig;
				udig = val % 10;
				ddig = val / 10;
				head2.next.val = udig;
				head2 = head2.next;
			}
			if (ddig != 0) {
				ListNode node = new ListNode(ddig);
				head2.next = node;
			}
			return l2;
		}
	}
}
