package com.gzy.leetcode;

public class LeetCode023 {
	public static void main(String[] args) {
		LeetCode021 lc = new LeetCode021();
		ListNode[] head = new ListNode[3];
		head[0] = new ListNode(0);
		head[1] = new ListNode(1);
		head[2] = new ListNode(2);
		lc.creatList(head[0], 1, 5);
		lc.creatList(head[1], 3, 9);
		lc.creatList(head[2], 4, 19);
		LeetCode023 lc23 = new LeetCode023();
		ListNode list = lc23.mergeKLists(head);
		while (list != null) {
			System.out.print(list.val + " ");
			list = list.next;
		}
	}

	public ListNode mergeKLists(ListNode[] lists) {
 		if(lists.length == 1)
			return lists[0];
		ListNode list = lists[0];
		for (int i = 1; i < lists.length;i++) {
			list = mergeTwoLists(lists[i], list);
		}
		return list;
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode p1 = l1;
		ListNode p2 = l2;
		ListNode head = new ListNode(0);
		ListNode tail = head;
		ListNode temp = null;
		while (p1 != null && p2 != null) {
			if (p1.val < p2.val) {
				temp = p1.next;
				tail.next = p1;
				tail = p1;
				p1 = temp;
			} else {
				temp = p2.next;
				tail.next = p2;
				tail = p2;
				p2 = temp;
			}
		}
		while (p1 != null) {
			tail.next = p1;
			tail = p1;
			p1 = p1.next;
		}
		while (p2 != null) {
			tail.next = p2;
			tail = p2;
			p2 = p2.next;
		}
		tail.next = null;
		// ListNode h = head;
		// while (h != null) {
		// System.out.println(h.val);
		// h = h.next;
		// }
		return head.next;
	}
}
