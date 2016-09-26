package com.gzy.leetcode;

public class LeetCode086 {
	public static void main(String[] args) {
		int[] array = {1,7,3,2,5,2};
		long startTime = System.currentTimeMillis();
		LeetCode086 lc = new LeetCode086();
		ListNode head = lc.createList(array);
//		head = lc.insertNodeToHead(head, 3);
//		head = lc.partition(head, 0);
//		head = lc.adjustList(head, 3);
		head = lc.newPartition(head, 4);
		lc.printList(head);
		long stopTime = System.currentTimeMillis();
		System.out.println("time:" + (stopTime - startTime));
		
	}
	//此外理解错了题意
	public ListNode partition(ListNode head, int x) {
		if(head == null) return null;
		ListNode temp = head;
		ListNode newHead = head;
		while (temp!=null&&temp.val != x) {
			temp = temp.next;
		}
		while (temp!=null && temp.next != null) {
//			System.out.println("node:" + temp.next.val);
			if (temp.next.val < x) {
//				System.out.println("del:" + temp.next.val);
				newHead = insertNodeToHead(newHead, temp.next.val);
				temp.next = temp.next.next;
			}
			temp = temp.next;
		}
		newHead = adjustList(newHead, x);
		return newHead;
	}
	//链表排序
	public ListNode adjustList(ListNode head, int val){
		ListNode head1 = head;
		ListNode tail = head;
		ListNode pre,temp,curNode = head.next;
		while(curNode!=null && curNode.val!=val){
			temp = curNode.next;
//			System.out.println(curNode.val);
			if(curNode.val <= head1.val){
//				System.out.println("<" + curNode.val);
				curNode.next = head1;
				head1 = curNode;
//				System.out.println("head1:" + head1.val);
//				System.out.println("head1.next" + head1.next.val);
			}else if(curNode.val >= tail.val){
//				System.out.println(">" + curNode.val);
				tail.next = curNode;
				tail = curNode;
//				System.out.println("tail:"+tail.val);
			}else{
				pre = head1;
//				System.out.println("head " + head1.val);
//				System.out.println("<val<" + curNode.val);
//				System.out.println("head.next.val " + head1.next.val);
				while(curNode.val >= pre.next.val)
				{
//					System.out.println(pre.val);
					pre = pre.next;
//					System.out.println("next" + pre.next.val);
				}
				
//				System.out.println("insert:"+curNode.val);
//				System.out.println(pre.val);
//				System.out.println(pre.next.val);
				
				curNode.next = pre.next;
				pre.next = curNode;	
				
//				System.out.println("--------------\n" +head1.val);
//				System.out.println(head1.next.val);
//				System.out.println(head1.next.next.val);
//				System.out.println(head1.next.next.next.val);
//				System.out.println("------------------");
				
			}
			curNode = temp;
		}
		tail.next = curNode;
		return head1;
	}

	public ListNode insertNodeToHead(ListNode head, int insertVal) {
		ListNode newNode = new ListNode(insertVal);
		// ListNode temp = head;
//		System.out.println("insertNum:" + insertVal);
		newNode.next = head;
		return newNode;
	}

	public ListNode createList(int[] array) {
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

	public void printList(ListNode head) {
//		System.out.println(head.val);
		System.out.print("list: ");
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
	public ListNode newPartition(ListNode head, int x) {
		if(head == null) return null;
		ListNode head1 = new ListNode(0);
		ListNode head2 = new ListNode(0);
		ListNode tail1 = head1,tail2 = head2;
		ListNode tempNode,curNode = head;
		while(curNode != null){
			tempNode = curNode.next;
			if(curNode.val < x){
				tail1.next = curNode;
				tail1 = curNode;
			}else{
				tail2.next = curNode;
				tail2 = curNode;
			}
			curNode = tempNode;
		}
		tail2.next = null;
		tail1.next = head2.next;
		return head1.next;
	}
}


